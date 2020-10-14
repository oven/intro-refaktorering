package no.kantega;

public class OrderValidator {

    void validateOrder(MenuItem drink, int quantity) {
        if (quantity > 2 && drink.isCocktail) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
    }
}
