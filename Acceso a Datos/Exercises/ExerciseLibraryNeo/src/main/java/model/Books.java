package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Books implements Serializable {
    private int id;
    private String title;
    private String category;
    private float price;
    private LocalDate datePublished;

    public Books() {

    }

    public Books(String title, float price) {
        this.title = title;
        this.price = price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
