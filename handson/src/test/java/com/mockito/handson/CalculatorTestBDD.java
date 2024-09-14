package com.mockito.handson;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

public class CalculatorTestBDD {

    @Test
    void testAdd_BDDStyle(){

        //Create a mock object of MathService
        MathService mathService = mock(MathService.class);
        given(mathService.add(2,3)).willReturn(5);

        //create a calculator object using mocked mathService
        Calculator calculator = new Calculator(mathService);

        int result = calculator.add(2,3);
        int expected = 5;

        assertEquals(expected, result);
        then(mathService).should().add(2,3); //verify interaction with mock
    }

    @Test
    void testAdd_ThrowsException_BDDStyle(){

        //Mock MathService to throw an exception
        MathService mathService = mock(MathService.class);
        given(mathService.add(2,3)).willThrow(new RuntimeException("Math error!!"));

        Calculator calculator = new Calculator(mathService);

        // When: Call the method, and expect an exception
        assertThrows(RuntimeException.class, () -> calculator.add(2,3), "Math error!!");

        // Then: Verify the interaction with the mock
        then(mathService).should().add(2,3);
    }
}
//With BDDMockito, you use:
//given() instead of when()
//willReturn() instead of thenReturn()
//willThrow() instead of thenThrow()
//then() to verify interactions