package no.kantega;

public class RecipeEntry {
    private final double quantity;
    private final Ingredient ingredient;

    public RecipeEntry(double quantity, Ingredient ingredient) {
        this.quantity = quantity;
        this.ingredient = ingredient;
    }

    public static RecipeEntry add(double quantity, Ingredient ingredient) {
        return new RecipeEntry(quantity, ingredient);
    }

    public int getPrice() {
        return (int)(quantity * ingredient.price);
    }
}
