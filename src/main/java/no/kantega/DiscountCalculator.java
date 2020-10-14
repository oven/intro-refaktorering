package no.kantega;

public abstract class DiscountCalculator {

    public static DiscountCalculator getInstance(MenuItem drink, boolean student) {
        if (drink.isCocktail) return new NoDiscountCalculator();
        if (student) return new StudentDiscountCalculator();
        return new NoDiscountCalculator();
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
            int discount = price / 10;
            return price - discount;
        }
    }
}
