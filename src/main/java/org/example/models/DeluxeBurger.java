package org.example.models;

public class DeluxeBurger extends Hamburger {
    private String chips = "Curvy";
    private String drink = "Coke";

    public DeluxeBurger() {
        super("Deluxe Burger", "Double", 19.10, "Double Sandwich");
    }

    // Getter metodları
    public String getChips() {
        return chips;
    }

    public String getDrink() {
        return drink;
    }

    // Ek malzeme eklemeyi engelleyen metotlar
    @Override
    public void addHamburgerAddition1(String name, double price) {
        System.out.println("\nDeluxe Burger için yeni malzeme eklenemez.");
    }

    @Override
    public void addHamburgerAddition2(String name, double price) {
        System.out.println("\nDeluxe Burger için yeni malzeme eklenemez.");
    }

    @Override
    public void addHamburgerAddition3(String name, double price) {
        System.out.println("\nDeluxe Burger için yeni malzeme eklenemez.");
    }

    @Override
    public void addHamburgerAddition4(String name, double price) {
        System.out.println("\nDeluxe Burger için yeni malzeme eklenemez.");
    }

    @Override
    public double itemizeHamburger() {
        double totalPrice = super.itemizeHamburger();
        System.out.println("Chips: " + this.chips);
        System.out.println("Drink: " + this.drink);
        return totalPrice;
    }
}
