package no.kantega;

import static no.kantega.Ingredient.*;

public enum MenuItem {
    ONE_BEER("hansa", 74),
    ONE_CIDER("grans", 103),
    A_PROPER_CIDER("strongbow", 110),
    GT("gt", GIN.price + TONIC_WATER.price + GREEN_STUFF.price),
    BACARDI_SPECIAL("bacardi_special", GIN.price / 2 + RUM.price + GRENADINE.price + LIME_JUICE.price);

    public final String id;
    private final int price;

    MenuItem(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
