package model;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

public class Books implements Serializable {
    private int id = 1;
    private String title;
    private String category;
    private float price;
    private Date datePublished;

    public Books() {

    }

    public Books( String title, String category, float price, Date datePublished) {
        id++;
        this.title = title;
        this.category = category;
        this.price = price;
        this.datePublished = datePublished;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }


    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", datePublished=" + datePublished +
                '}';
    }
}
