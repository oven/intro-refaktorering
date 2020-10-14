package no.kantega;

import static no.kantega.Ingredient.*;
import static no.kantega.MenuItem.*;

public class Pub {

    public int computeCost(MenuItem drink, boolean student, int quantity) {

        if (quantity > 2 && (drink == GT || drink == BACARDI_SPECIAL)) {
            throw new RuntimeException("Too many drinks, max 2.");
        }
        int price;
        if (drink.equals(ONE_BEER)) {
            price = 74;
        } else if (drink.equals(ONE_CIDER)) {
            price = 103;
        }
        else if (drink.equals(A_PROPER_CIDER)) price = 110;
        else if (drink.equals(GT)) {
            price = GIN.price + TONIC_WATER.price + GREEN_STUFF.price;
        }
        else if (drink.equals(BACARDI_SPECIAL)) {
            price = GIN.price / 2 + RUM.price + GRENADINE.price + LIME_JUICE.price;
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
