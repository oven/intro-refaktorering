package no.kantega;

public enum MenuItem {
    ONE_BEER("hansa", 74),
    ONE_CIDER("grans"),
    A_PROPER_CIDER("strongbow"),
    GT("gt"),
    BACARDI_SPECIAL("bacardi_special");

    public final String id;
    private final int price;

    MenuItem(String id) {
        this.id = id;
        this.price = 0;
    }

    MenuItem(String id, int price) {
        this.id = id;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
