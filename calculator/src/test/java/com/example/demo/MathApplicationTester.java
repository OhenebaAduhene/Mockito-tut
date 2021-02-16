package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    @Mock
    CalculatorService service;

    @Test
    public void testAdd(){
        when(service.add(10.0,20.0)).thenReturn(30.00);
        Assert.assertEquals(mathApplication.add(10.0,20.0),30.0,0);
    }

    @Test
    public void testSubtract(){
        when(service.subtract(40.0,20.0)).thenReturn(20.00);
        Assert.assertEquals(mathApplication.subtract(40.0,20.0),20.0,0);
    }

}
