package no.kantega;

import static no.kantega.MenuItem.*;

public class Pub {

    public int computeCost(MenuItem drink, boolean student, int quantity) {

        if (quantity > 2 && (drink == GT || drink == BACARDI_SPECIAL)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;
        if (drink.equals(ONE_BEER)) {
            price = drink.getPrice();
        } else if (drink.equals(ONE_CIDER)) {
            price = drink.getPrice();
        }
        else if (drink.equals(A_PROPER_CIDER)) price = drink.getPrice();
        else if (drink.equals(GT)) {
            price = drink.getPrice();
        }
        else if (drink.equals(BACARDI_SPECIAL)) {
            price = drink.getPrice();
        }
        else {
            throw new RuntimeException("No such drink exists");
        }
        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
            price = price - price/10;
        }
        return price * quantity;
    }

}
