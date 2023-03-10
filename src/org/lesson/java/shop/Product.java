package org.lesson.java.shop;

import java.text.DecimalFormat;
import java.util.Random;

public class Product {

    // Props
    private final int code;
    private String name;
    private String description;
    private double price;
    private static final double VAT = 0.21;

    //Constructor

    public Product(){
        Random rnd = new Random();
        code = rnd.nextInt(1, 1001);
    }
    public Product(String name){
        Random rnd = new Random();
        code = rnd.nextInt(1, 1001);
        this.name = name;
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

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Product{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    //Custom methods

    public String getPriceWithVAT(){
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        return decimalFormat.format(price+= price * VAT);
    }

    public String getExtendedName(){
        return name + code;
    }
}