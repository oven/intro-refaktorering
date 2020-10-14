package no.kantega;

public class Pub {

    public int computeCost(MenuItem drink, boolean student, int quantity) {
        validateOrder(drink, quantity);
        int price = DiscountCalculator.applyDiscount(drink, student);
        return price * quantity;
    }

    private void validateOrder(MenuItem drink, int quantity) {
        if (quantity > 2 && drink.isCocktail) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
    }
}
