package org.example.models;

public class HealthyBurger extends Hamburger {
    private String healthyExtra1Name, healthyExtra2Name;
    private double healthyExtra1Price, healthyExtra2Price;

    public HealthyBurger(String name, double price, String breadRollType) {
        super(name, "Tofu", price, breadRollType);
    }

    public void addHealthyAddition1(String name, double price) {
        this.healthyExtra1Name = name;
        this.healthyExtra1Price = price;
    }

    public void addHealthyAddition2(String name, double price) {
        this.healthyExtra2Name = name;
        this.healthyExtra2Price = price;
    }

    @Override
    public double itemizeHamburger() {
        double totalPrice = super.itemizeHamburger();
        if (healthyExtra1Name != null) {
            System.out.println("HealthyAddition1: " + healthyExtra1Name);
            totalPrice += healthyExtra1Price;
        }
        if (healthyExtra2Name != null) {
            System.out.println("HealthyAddition2: " + healthyExtra2Name);
            totalPrice += healthyExtra2Price;
        }
        System.out.println("Price: " + totalPrice);
        return totalPrice;
    }
}
