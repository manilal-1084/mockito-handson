package com.mockito.handson;

public class NotificationService {

    public void sendEmail(String email, String message){
        //Logic to send email
        System.out.println("Email send to : "+email+ " with message : " + message);
    }
}
