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
        printMenu(m);

    }

    private static void printMenu(Menu menu) {
        for (MenuObject item : menu.getMenuItems()) {
            if (item instanceof Pizza pizza) {
                System.out.println("------PIZZA------");
                System.out.println(item.getName() + "-" + item.getPrice() + "$" + "-- calories" + pizza.getCalories());
                System.out.println("Toppings" + pizza.getToppings());
            } else if (item instanceof Drink) {
                System.out.println("------DRINK------");
                System.out.println(item.getName() + "-" + item.getPrice() + "$");
            } else if (item instanceof Topping) {
                System.out.println("------TOPPING------");
                System.out.println(item.getName() + "-" + item.getPrice() + "$");

            }
        }
    }
}
