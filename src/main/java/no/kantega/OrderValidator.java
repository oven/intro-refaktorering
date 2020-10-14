package no.kantega;

public class OrderValidator {

    public static final int MAX_COCKTAILS = 2;

    void validateOrder(MenuItem drink, int quantity) {
        if (quantity > MAX_COCKTAILS && drink.isCocktail) {
            throw new RuntimeException("Too many drinks, max " + MAX_COCKTAILS + ".");
        }
    }
}
