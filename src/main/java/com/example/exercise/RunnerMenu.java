package com.example.exercise;

import com.example.exercise.Classes.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class RunnerMenu implements CommandLineRunner {
    @Autowired
    private AnnotationConfigApplicationContext ctx;

    @Override

    public void run(String... args) throws Exception {

        Menu m = (Menu) ctx.getBean("menu");
        log.info(String.valueOf(m));
        //  Menu.showMenu(m);


        Double seatPrice = (Double) ctx.getBean("getCopertoCost");


        Pizza margherita = ctx.getBean("margherita", Pizza.class);
        Pizza hawaiian = ctx.getBean("hawaiian", Pizza.class);
        Pizza diavola = ctx.getBean("diavola", Pizza.class);

        Topping ham = ctx.getBean("ham", Topping.class);
        Topping pineapple = ctx.getBean("pineapple", Topping.class);
        Topping onions = ctx.getBean("onions", Topping.class);
        Topping cheese = ctx.getBean("cheese", Topping.class);
        Topping salami = ctx.getBean("salami", Topping.class);

        Drink lemonade = ctx.getBean("lemonade", Drink.class);
        Drink water = ctx.getBean("water", Drink.class);
        Drink wine = ctx.getBean("wine", Drink.class);

        Table table1 = ctx.getBean("table1", Table.class);
        Table table2 = ctx.getBean("table2", Table.class);
        Table table3 = ctx.getBean("table3", Table.class);
        Table table4 = ctx.getBean("table4", Table.class);


        List<MenuObject> orderlist1 = new ArrayList<>(Arrays.asList(margherita, hawaiian, diavola, lemonade, water));


        Order order1 = new Order(1, 3, table1, orderlist1);
        System.out.printf("----- AGGIUNTA ORDINE NUM %s -----%n", order1.getOrderNum());
        System.out.println("---------------------------------------");
        System.out.printf("----- PREZZO ORDINE PRE COPERTI NUM %s ----- %n", order1.getOrderNum());
        System.out.println("---------------------------------------");
        order1.calcTotal();
        System.out.println(order1.getTotal());
        order1.setTotal(order1.getTotal() + (order1.getClients() * seatPrice));
        System.out.printf("----- PREZZO FINALE ORDINE NUM %s -----%n", order1.getOrderNum());
        System.out.println("---------------------------------------");
        System.out.println(order1.getTotal());
        System.out.println("---------------------------------------");


    }


}
