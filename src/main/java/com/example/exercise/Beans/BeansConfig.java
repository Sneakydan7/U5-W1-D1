package com.example.exercise.Beans;

import com.example.exercise.Classes.Drink;
import com.example.exercise.Classes.Menu;
import com.example.exercise.Classes.Pizza;
import com.example.exercise.Classes.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class BeansConfig {
    // --------------------------------------PIZZAS---------------------------------------------

    @Bean
    public Pizza margherita() {
        return new Pizza("Margherita", 5.00);
    }

    @Bean
    public Pizza hawaiian() {
        Pizza hawaiian = new Pizza("Hawaiian", 7.00);
        hawaiian.addATopping(pineapple());
        return hawaiian;
    }

    @Bean
    public Pizza diavola() {
        Pizza diavola = new Pizza("Diavola", 9.00);
        diavola.addATopping(salami());
        diavola.addATopping(onions());
        return diavola;
    }


    // --------------------------------------TOPPINGS---------------------------------------------
    @Bean
    public Topping ham() {
        return new Topping("Ham", 0.99, 35);
    }

    @Bean
    public Topping pineapple() {
        return new Topping("Pineapple", 0.79, 24);
    }

    @Bean
    public Topping onions() {
        return new Topping("Onions", 0.69, 22);
    }

    @Bean
    public Topping cheese() {
        return new Topping("Cheese", 0.69, 92);
    }

    @Bean
    public Topping salami() {
        return new Topping("Salami", 0.99, 89);
    }

// ----------------------------------------DRINKS---------------------------------------------


    @Bean
    public Drink lemonade() {
        return new Drink("Lemonade", 1.29, 128);
    }

    @Bean
    public Drink water() {
        return new Drink("Water", 1.29, 0);
    }

    @Bean
    public Drink wine() {
        return new Drink("Wine", 7.49, 607);
    }


    // --------------------------------------MENU---------------------------------------------


    @Bean(name = "menu")
    public Menu menu() {

        Menu menu = new Menu();

        menu.addMenuItem(margherita());
        menu.addMenuItem(diavola());
        menu.addMenuItem(hawaiian());
        menu.addMenuItem(margherita());

        menu.addMenuItem(ham());
        menu.addMenuItem(pineapple());
        menu.addMenuItem(onions());
        menu.addMenuItem(cheese());
        menu.addMenuItem(salami());

        menu.addMenuItem(water());
        menu.addMenuItem(lemonade());
        menu.addMenuItem(wine());


        return menu;
    }


}
