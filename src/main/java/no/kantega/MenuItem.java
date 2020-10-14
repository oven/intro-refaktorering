package no.kantega;

import static no.kantega.Ingredient.*;

public enum MenuItem {
    ONE_BEER("hansa", 74, false),
    ONE_CIDER("grans", 103, false),
    A_PROPER_CIDER("strongbow", 110, false),
    GT("gt", GIN.price + TONIC_WATER.price + GREEN_STUFF.price, true),
    BACARDI_SPECIAL("bacardi_special", GIN.price / 2 + RUM.price + GRENADINE.price + LIME_JUICE.price, true);

    public final String id;
    private final int price;
    public final boolean isCocktail;

    MenuItem(String id, int price, boolean isCocktail) {
        this.id = id;
        this.price = price;
        this.isCocktail = isCocktail;
    }

    public int getPrice() {
        return price;
    }
}
