package com.example.exercise.Classes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Drink extends MenuObject {
    private int calories;

    public Drink(String name, Double price, int calories) {
        super(name, price);
        this.calories = calories;
    }
}
