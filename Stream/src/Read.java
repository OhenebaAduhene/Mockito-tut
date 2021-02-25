import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Read {

    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("input")));
//            List<String> words = Arrays.asList(content.split(" "));
            List<String> words = Arrays.asList(content.split("[\\P{L}]+"));
//            List<String> content = Collections.singletonList(new String(Files.readAllBytes(Paths.get("input"))));
//            content.forEach(System.out::println);
//            Stream<String> words = content.stream();

            final Stream<Stream<Character>> streamStream = words.stream().map(Read::characterStream);
//            streamStream.forEach(x->x.forEach(System.out::println));


            final List<String> longWords = words.stream().filter(x -> x.length() >= 12)
                    .map(String::toUpperCase)
                    .filter(x-> x.charAt(0) == 'C')
                    .collect(Collectors.toList());

//            longWords.forEach(System.out::println);

            Stream<Character> characters = characterStream("Hello");
//            characters.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }


//        Limit in java stream
        Stream<Integer> enumValue = Stream.iterate(0, n->n+2);
        List<Integer> newList = enumValue.limit(10).collect(Collectors.toList());
//        System.out.println(newList);
//        System.out.println(enumValue.collect(Collectors.toList()));
        
    }

    public static Stream<Character> characterStream(String s){
        List<Character> arr = new ArrayList<>();
        for (char c : s.toCharArray()) arr.add(c);
        return arr.stream();
    }
}
