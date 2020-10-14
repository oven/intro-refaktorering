package no.kantega;

import java.util.Arrays;

import static no.kantega.Ingredient.*;
import static no.kantega.RecipeEntry.add;

public enum MenuItem {
    ONE_BEER(74),
    ONE_CIDER(103),
    A_PROPER_CIDER(110),
    GT(add(1, GIN), add(1, TONIC_WATER), add(1, GREEN_STUFF)),
    BACARDI_SPECIAL(add(0.5, GIN), add(1, RUM), add(1, GRENADINE), add(1, LIME_JUICE));

    private final int price;
    public final boolean isCocktail;

    MenuItem(RecipeEntry... ingredients) {
        this.isCocktail = true;
        this.price = Arrays.stream(ingredients).mapToInt(RecipeEntry::getPrice).sum();
    }

    MenuItem(int price) {
        this.price = price;
        this.isCocktail = false;
    }

    public int getPrice() {
        return price;
    }
}
