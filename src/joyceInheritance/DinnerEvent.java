package joyceInheritance;

public class DinnerEvent extends Event{
    private int entree;
    private int side1;
    private int side2;
    private int dessert;
    private static final String[] ENTREE_OPTIONS = {"Steak", "Chicken", "Fish"};
    private static final String[] SIDE_OPTIONS = {"Salad", "Mashed Potatoes", "Grilled Vegetables"};
    private static final String[] DESSERT_OPTIONS = {"Cheesecake", "Chocolate Cake", "Fruit Salad"};

    public DinnerEvent(int eventNumber, int guests, int entree, int side1, int side2, int dessert) {
        super(eventNumber, guests);
        this.entree = entree;
        this.side1 = side1;
        this.side2 = side2;
        this.dessert = dessert;
    }

    public String getMenu() {
        return "Entree: " + ENTREE_OPTIONS[entree - 1] +
                "\nSide 1: " + SIDE_OPTIONS[side1 - 1] +
                "\nSide 2: " + SIDE_OPTIONS[side2 - 1] +
                "\nDessert: " + DESSERT_OPTIONS[dessert - 1];
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMenu:\n" + getMenu();
    }
}
