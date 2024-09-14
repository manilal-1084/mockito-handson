package com.mockito.handson;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CalculatorTestAnnotation {

    @Mock
    MathService mathService;

    @InjectMocks
    Calculator calculator;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void Test(){
        when(mathService.add(2,4)).thenReturn(6);
        assertEquals(6,calculator.add(2,4));
    }
}
