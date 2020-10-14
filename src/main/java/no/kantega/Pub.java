package no.kantega;

public class Pub {

    public int computeCost(MenuItem drink, boolean student, int quantity) {

        if (quantity > 2 && drink.isCocktail) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price = drink.getPrice();
        if (student && !drink.isCocktail) {
            price = price - price/10;
        }
        return price * quantity;
    }

}
