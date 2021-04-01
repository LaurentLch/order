package com.switchfully.order.domain.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class CustomerOrder {

    //INSTANCE VARIABLES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int amount;
    private double price;

    @OneToMany
    @JoinColumn(name = "customerorder_id")
    private Set<Item> items = new HashSet<>();


    //CONSTRUCTORS
    public CustomerOrder() {
    }

    public CustomerOrder(int amount, double price) {
        this.amount = amount;
        this.price = price;
    }

    //GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //TO STRING METHOD
    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                ", items=" + items +
                '}';
    }

    //EQUALS & HASHCODE METHODS
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomerOrder that = (CustomerOrder) o;

        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
