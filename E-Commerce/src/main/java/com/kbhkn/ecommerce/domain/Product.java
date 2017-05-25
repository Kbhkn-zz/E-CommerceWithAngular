package com.kbhkn.ecommerce.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kbhkn on 4/30/17.
 */
@Entity
@Table(name = "tbl_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private int id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private double price;

    @OneToMany(fetch=FetchType.LAZY, mappedBy = "productId", cascade = CascadeType.ALL)
    private List<Order> orders;

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
