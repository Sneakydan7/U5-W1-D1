package com.example.exercise.Classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class Pizza extends MenuObject {
    private List<Topping> toppings = new ArrayList<>();
    private int calories;

    public Pizza(String name, Double price) {
        super(name, price);
        this.calories = 600;
        this.addATopping(new Topping("Tomato", 0.50, 50));
        this.addATopping(new Topping("Cheese", 0.50, 60));

    }

    public void addATopping(Topping topping) {
        toppings.add(topping);
    }
}
