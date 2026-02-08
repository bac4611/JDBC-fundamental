package model;

public class Productmodel {
    private int id;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String status;

    public Productmodel(int id, String name, double price, int quantity, String description, String status) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.status = status;
    }
}
