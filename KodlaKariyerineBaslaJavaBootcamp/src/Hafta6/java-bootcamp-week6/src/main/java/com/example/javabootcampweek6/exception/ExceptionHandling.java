package com.example.javabootcampweek6.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//genel exceptionların handle edildiği class
@RestControllerAdvice
public class ExceptionHandling {

    //null exception'ı görürse patlatır
    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> nullPointerExceptionHandler(NullPointerException e){
       //exception mesajı
        String exceptionMesage= "NException Message: "+e.getMessage();
        //mesajı ve 500 kodunu döndürür
        return new ResponseEntity<String>(exceptionMesage,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //başka bir exception olursa mu metod ile handle edilir
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
       //exception mesajı
        String exceptionMesage = "Exception Message: "+e.getMessage();
        //mesajı ve 400 kodunu döndürür
        return new ResponseEntity<String>(exceptionMesage,HttpStatus.BAD_REQUEST);
    }
}
