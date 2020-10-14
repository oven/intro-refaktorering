package no.kantega;

public class Pub {
    private final OrderValidator orderValidator = new OrderValidator();

    public int computeCost(MenuItem drink, boolean student, int quantity) {
        orderValidator.validateOrder(drink, quantity);
        int price = DiscountCalculator.getInstance(drink, student).applyDiscount(drink);
        return price * quantity;
    }
}
