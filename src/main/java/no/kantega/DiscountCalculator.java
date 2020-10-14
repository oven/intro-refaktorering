package no.kantega;

public abstract class DiscountCalculator {

    public static int applyDiscount(MenuItem drink, boolean student) {
        if (drink.isCocktail) return new NoDiscountCalculator().applyDiscount(drink);
        if (student) return new StudentDiscountCalculator().applyDiscount(drink);

        return new NoDiscountCalculator().applyDiscount(drink);
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
