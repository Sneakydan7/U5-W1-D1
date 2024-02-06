package com.example.exercise.Classes;

import com.example.exercise.Enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
public class Order {

    private List<MenuObject> order;

    private int orderNum;

    private OrderStatus status;

    private int clients;

    private LocalTime time;

    private Table table;

    private Double total;

    public Order(int orderNum, int clients, Table table, List<MenuObject> order) {
        this.orderNum = orderNum;
        this.status = OrderStatus.PENDING;
        this.clients = clients;
        this.time = LocalTime.now();
        this.order = order;
        this.table = table;
    }


    public void calcTotal() {
        Double sum = 0.00;

        for (MenuObject item : order) {
            sum += item.getPrice();

        }


        this.setTotal(sum);

    }


}
