package com.example.exercise.Beans;

import com.example.exercise.Classes.*;
import com.example.exercise.Enums.TableStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class BeansConfig {
    @Bean
    public Double getCopertoCost(@Value("${coperto.cost}") Double cost) {
        return cost;
    }

    // --------------------------------------PIZZAS---------------------------------------------

    @Bean
    public Pizza margherita() {
        return new Pizza("Margherita", 5.00);
    }

    @Bean
    public Pizza hawaiian() {
        Pizza hawaiian = new Pizza("Hawaiian", 7.00);
        hawaiian.addATopping(pineapple());
        hawaiian.calcPrice();
        return hawaiian;
    }

    @Bean
    public Pizza diavola() {
        Pizza diavola = new Pizza("Diavola", 9.00);
        diavola.addATopping(salami());
        diavola.addATopping(onions());
        diavola.calcPrice();
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


    // --------------------------------------TABLES---------------------------------------------

    @Bean
    public Table table1() {
        return new Table(1, 4);
    }

    @Bean
    public Table table2() {
        return new Table(2, 8);
    }

    @Bean
    public Table table3() {
        return new Table(3, 5);
    }

    @Bean
    public Table table4() {
        return new Table(4, 2);
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
