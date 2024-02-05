package com.example.exercise.Classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Topping extends MenuObject {
    private int calories;

    public Topping(String name, Double price, int calories) {
        super(name, price);
        this.calories = calories;
    }
}
