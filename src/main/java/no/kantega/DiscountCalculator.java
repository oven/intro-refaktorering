package no.kantega;

public class DiscountCalculator {

    public static int applyDiscount(MenuItem drink, boolean student) {
        int price = drink.getPrice();
        if (student && !drink.isCocktail) {
            price = price - price/10;
        }
        return price;
    }
}
