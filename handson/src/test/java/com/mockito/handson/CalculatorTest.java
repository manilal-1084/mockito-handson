package com.mockito.handson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CalculatorTest {

    @Test
    public void testAdd(){

        //Create a mock object of MathService
        MathService mathService = mock(MathService.class);

        //stub the add method when 2,3 passed as argument, return should be 5
        when(mathService.add(2,3)).thenReturn(5);

        //create a calculator object with the mocked service
        Calculator calculator = new Calculator(mathService);

        //Test the add method
        int result = calculator.add(2,3);

        //verify that the method called with the correct arguments
        verify(mathService).add(2,3);

        //Assert the result
        assertEquals(5, result);
    }


}
