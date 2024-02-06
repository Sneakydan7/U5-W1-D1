package com.example.exercise;

import com.example.exercise.Classes.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DemoApplication.class);


        Menu m = (Menu) ctx.getBean("menu");
        Menu.showMenu(m);
        

    }


}
