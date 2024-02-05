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


}
