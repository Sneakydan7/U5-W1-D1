package com.example.exercise.Classes;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public abstract class MenuObject {
    private String name;
    private Double price;


}
