package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Authors implements Serializable {
    private String dni;
    private String name;
    private String address;
    private int age;
    private String nationality;
    private List<Books> book = new ArrayList<>();

    public Authors() {
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public List<Books> getBook() {
        return book;
    }

    public void setBook(List<Books> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", nationality='" + nationality + '\'' +
                ", booksList=" + book +
                '}';
    }
}
