package no.kantega;

public abstract class DiscountCalculator {

    public static int applyDiscount(MenuItem drink, boolean student) {
        if (drink.isCocktail) return new NoDiscountCalculator().applyDiscount(drink);
        if (student) return new StudentDiscountCalculator().applyDiscount(drink);

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

    public static class StudentDiscountCalculator extends DiscountCalculator {

        @Override
        public int applyDiscount(MenuItem drink) {
            int price = drink.getPrice();
            price = price - price / 10;
            return price;
        }
    }
}
