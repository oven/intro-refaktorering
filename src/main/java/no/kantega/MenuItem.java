package no.kantega;

import static no.kantega.Ingredient.*;
import static no.kantega.RecipeEntry.add;

public enum MenuItem {
    ONE_BEER("hansa", 74, false),
    ONE_CIDER("grans", 103, false),
    A_PROPER_CIDER("strongbow", 110, false),
    GT("gt", add(1, GIN), add(1, TONIC_WATER), add(1, GREEN_STUFF)),
    BACARDI_SPECIAL("bacardi_special", GIN.price / 2 + RUM.price + GRENADINE.price + LIME_JUICE.price, true);

    public final String id;
    private final int price;
    public final boolean isCocktail;

    MenuItem(String id, RecipeEntry... ingredients) {
        this.id = id;
        this.isCocktail = true;
        int price = 0;
        for (RecipeEntry ingredient : ingredients) {
            price += ingredient.getPrice();
        }
        this.price = price;
    }

    MenuItem(String id, int price, boolean isCocktail) {
        this.id = id;
        this.price = price;
        this.isCocktail = isCocktail;
    }

    public int getPrice() {
        return price;
    }
}
