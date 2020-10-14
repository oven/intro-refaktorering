package no.kantega;

public abstract class DiscountCalculator {

    public static int applyDiscount(MenuItem drink, boolean student) {
        if (drink.isCocktail) return new NoDiscountCalculator().applyDiscount(drink);

        int price = drink.getPrice();
        if (student && !drink.isCocktail) {
            price = price - price / 10;
        }
        return price;
    }

    public abstract int applyDiscount(MenuItem drink);

    public static class NoDiscountCalculator extends DiscountCalculator {
        @Override
        public int applyDiscount(MenuItem drink) {
            return drink.getPrice();
        }
    }
}
