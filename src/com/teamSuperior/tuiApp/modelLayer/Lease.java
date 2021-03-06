package com.teamSuperior.tuiApp.modelLayer;

import java.io.Serializable;

/**
 * Lease model class.
 */
public class Lease implements Serializable {
    private int id, leaseMachineId, customerId;
    private String borrowDate, returnDate;
    private double price;

    public Lease(int id, int leaseMachineId, int customerId, String borrowDate, String returnDate, double price) {
        this.id = id;
        this.leaseMachineId = leaseMachineId;
        this.customerId = customerId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLeaseMachineId() {
        return leaseMachineId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d%nLease Machine ID: %d%nCustomer ID: %d%nBorrow date: %s%nReturn date: %s%nPrice: $%.2f%n%n",
                id, leaseMachineId, customerId, borrowDate, returnDate, price
        );
    }
}
