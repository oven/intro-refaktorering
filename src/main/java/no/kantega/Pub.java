package no.kantega;

import static no.kantega.MenuItem.*;

public class Pub {


    public static final int RUM = 65;
    public static final int GRENADINE = 10;
    public static final int LIME_JUICE = 10;
    public static final int GREEN_STUFF = 10;
    public static final int TONIC_WATER = 20;
    public static final int GIN = 85;

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
            price = gin() + tonicWater() + greenStuff();
        }
        else if (drink.equals(BACARDI_SPECIAL)) {
            price = gin() / 2 + rum() + grenadine() + limeJuice();
        }
        else {
            throw new RuntimeException("No such drink exists");
        }
        if (student && (drink == ONE_CIDER || drink == ONE_BEER || drink == A_PROPER_CIDER)) {
            price = price - price/10;
        }
        return price * quantity;
    }

    private int rum() {
        return RUM;
    }

    private int grenadine() {
        return GRENADINE;
    }

    private int limeJuice() {
        return LIME_JUICE;
    }

    private int greenStuff() {
        return GREEN_STUFF;
    }

    private int tonicWater() {
        return TONIC_WATER;
    }

    private int gin() {
        return GIN;
    }
}
