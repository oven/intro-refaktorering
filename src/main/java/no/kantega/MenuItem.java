package no.kantega;

public enum MenuItem {
    ONE_BEER("hansa"),
    ONE_CIDER("grans"),
    A_PROPER_CIDER("strongbow"),
    GT("gt"),
    BACARDI_SPECIAL("bacardi_special");

    public final String id;

    MenuItem(String id) {
        this.id = id;
    }
}
