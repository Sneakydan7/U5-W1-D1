package com.example.exercise.Classes;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class Menu {
    private List<MenuObject> menuItems = new ArrayList<>();


    public void addMenuItem(MenuObject item) {
        menuItems.add(item);
    }

    public static void showMenu(Menu menu) {
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
