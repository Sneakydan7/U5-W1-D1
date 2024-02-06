package com.example.exercise.Classes;

import com.example.exercise.Enums.TableStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Table {
    private int tableNumber;

    private int seats;

    private TableStatus status;

    public Table(int tableNumber, int seats) {
        this.tableNumber = tableNumber;
        this.seats = seats;
        this.status = TableStatus.FREE;
    }
}
