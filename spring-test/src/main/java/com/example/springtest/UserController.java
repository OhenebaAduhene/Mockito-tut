package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

//    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
//        System.out.println(userService.getMyUsers().get(0).getId());
        return userService.getMyUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id){

        return (User) userService.getMyUsers().stream()
                .filter(userid -> userid.getId() == id)
                .collect(Collectors.toList());
    }

}
