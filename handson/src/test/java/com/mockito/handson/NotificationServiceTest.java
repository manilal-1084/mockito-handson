package com.mockito.handson;
//Write a Test Using Mockito and ArgumentCaptor


import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NotificationServiceTest {

    @Test
    void testSendEmail_ArgumentCaptor(){
        //Create a mock of NotificationService
        NotificationService notificationService = mock(NotificationService.class);

        //Call the sendEmail method on mock
        notificationService.sendEmail("test@example.com","Welcome to our service!");

        //Create ArgumentCaptor for capturing the method arguments
        ArgumentCaptor<String> emailCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> messageCaptor = ArgumentCaptor.forClass(String.class);

        //Verify that sendEmail() method was called and capture the arguments
        verify(notificationService).sendEmail(emailCaptor.capture(), messageCaptor.capture());

        // Now you can use getValue() to retrieve the captured arguments
        System.out.println("Captured Email: " + emailCaptor.getValue());
        System.out.println("Captured Message: " + messageCaptor.getValue());

        //Assert that the capture email and message match the expected values
        assertEquals("test@example.com",emailCaptor.getValue());
        assertEquals("Welcome to our service!",messageCaptor.getValue());

    }
}
