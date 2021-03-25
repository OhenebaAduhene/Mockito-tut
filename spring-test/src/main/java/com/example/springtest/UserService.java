package com.example.springtest;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    List<User> myUsers = new ArrayList<>(Arrays.asList(

            new User(1,"wisdom","kumasi"),
            new User(2,"james","accra"),
            new User(3,"vincent","accra")
    ));

    public List<User> getMyUsers(){
        return myUsers;
    }

}
