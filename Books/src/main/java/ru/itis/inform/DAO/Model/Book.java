package ru.itis.inform.DAO.Model;

import javax.persistence.*;

@Entity
@Table(name = "newbooks")
public class Book {
    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "price", length = 10)
    private String price;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Book(int id, String name, String price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Book() {
    }

    public Book(String name, String price){
        this.name = name;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public String getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", id=" + id +
                '}';
    }

    public void setPrice(String price){
        this.price = price;
    }
}