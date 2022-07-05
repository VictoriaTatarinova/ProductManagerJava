package ru.netology.ProductManagerJava;

public class Book extends Product {
    private String author;

    public Book() {
    }

    public Book(String author) {
        this.author = author;
    }

    public Book(int id, String name, int cost, String author) {
        super(id, name, cost);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
