package com.springboot.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * Hello world!
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class);
        /*String s =null;
        System.out.println("before exception");
        //try{
            s.length();
        //}
        //catch(NullPointerException e){
            System.out.println("s is null");
        //}
        System.out.println("outside try-catch");*/
    }
}
