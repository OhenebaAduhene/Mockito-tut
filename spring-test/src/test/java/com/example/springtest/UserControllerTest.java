package com.example.springtest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserControllerTest {

    List<User> myUsers = new ArrayList<>(Arrays.asList(

            new User(1,"wisdom","kumasi"),
            new User(2,"james","accra"),
            new User(3,"vincent","accra")
    ));

    private final UserController controller;

    @Autowired
    public UserControllerTest(UserController controller) {
        this.controller = controller;
    }

    @Test
    public void getUserById(){
        User user = controller.getUserById(1);

        when(controller.getUserById(1)).thenReturn(user);

        Assertions.assertEquals(1,myUsers.get(0).getId());

    }
}
