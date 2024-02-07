package com.example.exercise;

import com.example.exercise.Classes.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private AnnotationConfigApplicationContext ctx;


    @AfterEach
    public void afterEach() {
        System.out.println("AFTER EACH");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("AFTER ALL");

    }

    @Test
    public void testPizzaAddedToOrder() {
        Pizza pizza = new Pizza("Margherita", 5.00);
        Table table = new Table(1, 5);
        List<MenuObject> list = new ArrayList<>();
        list.add(pizza);

        Order order = new Order(1, 5, table, list);
        assertEquals(1, list.size());
        order.calcTotal();
        assertEquals(pizza.getPrice(), order.getTotal());
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 10})
    public void testTotalCostWithPizzas(int pizzas) {
        Pizza pizza = new Pizza("Margherita", 5.00);
        Table table = new Table(1, 5);
        List<MenuObject> list = new ArrayList<>();
        for (int i = 0; i < pizzas; i++) {
            list.add(pizza);
        }

        Order order = new Order(1, 5, table, list);
        order.calcTotal();

        Double expectedTotal = pizza.getPrice() * pizzas;
        assertEquals(expectedTotal, order.getTotal());


    }


    @ParameterizedTest
    @CsvSource({"margherita , 1 ", "water , 5 ", "wine , 5",})
    public void testTotalCostWithDifferentItemBeans(String menuItem, int quantity) {
        Table table = new Table(1, 5);
        List<MenuObject> list = new ArrayList<>();
        MenuObject item = (MenuObject) ctx.getBean(menuItem);
        for (int i = 0; i < quantity; i++) {
            list.add(item);
        }
        Order order = new Order(1, 5, table, list);
        order.calcTotal();

        Double expectedTotal = item.getPrice() * quantity;
        assertEquals(expectedTotal, order.getTotal());
    }
}
