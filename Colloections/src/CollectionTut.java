import java.util.*;
import java.util.stream.Stream;

public class CollectionTut {

    public static void main(String[] args) {

//        Vector enum iteration

        Vector<String> myVector = new Vector(Arrays.asList("Addy", "Nkoah", "Wisdom"));

        Enumeration<String> enumeration = myVector.elements();

        while (enumeration.hasMoreElements()){
            String val = enumeration.nextElement();

            if ("Wisdom".equals(val)) {
                myVector.add("Oheneba");
            }
//            System.out.println(val);
        }


//        ArrayList iterator iteration

        ArrayList<String> myArrayList = new ArrayList<>(Arrays.asList("Addy", "Nkoah", "Wisdom"));

        Iterator<String> myIterator = myArrayList.iterator();



        while (myIterator.hasNext()){
            String val = myIterator.next();

            if ("Nkoah".equals(val)){
                myArrayList.add("Oheneba");
            }
            System.out.println(val);
        }


//        ArrayList`
        ArrayList<String> nameOfPeople = new ArrayList<>();
        nameOfPeople.add("Wisdom");
        nameOfPeople.add("Aduhene");
        nameOfPeople.add("Nkoah");

        List<String> syncPeople = Collections.synchronizedList(nameOfPeople);

        nameOfPeople.add("Addy");

//        System.out.println(syncPeople);
//        System.out.println(nameOfPeople);
    }
}
