package org.lesson.java.shop;

public class Main {
    public static void main(String[] args) {
        Product test = new Product();
        test.setPrice(10.5);
        test.setName("Prodotto bello");
        test.setDescription("This product is a wonderful test");
        System.out.println(test.getPriceWithVAT());
        System.out.println(test.getPriceWithVAT());
        System.out.println(test.getPriceWithVAT());

    }
}
