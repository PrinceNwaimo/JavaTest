package diettel8;

public enum Food {
    APPLE("fruit", 95),
    BANANA("fruit", 105),
    CARROT("vegetable", 45);

    private final String type;
    private final int calories;

    Food(String type, int calories) {
        this.type = type;
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public int getCalories() {
        return calories;
    }
}
