package diettel8;

public class FoodTest {
    public static void main(String[] args) {
        for (Food food : Food.values()) {
            System.out.println("Food: " + food.name());
            System.out.println("Type: " + food.getType());
            System.out.println("Calories: " + food.getCalories() + " per serving");
            System.out.println();
        }
    }
}
