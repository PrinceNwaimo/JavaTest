package makingAdifference;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HealthierIngredients {
    private static final Map<String, String> substitutions = new HashMap<>();

    static {
        substitutions.put("sour cream", "yogurt");
        substitutions.put("milk", "evaporated milk and water or soy milk");
        substitutions.put("sugar", "honey, molasses or agave nectar");
        substitutions.put("butter", "margarine or yogurt");
        substitutions.put("flour", "rye or rice flour");
        substitutions.put("mayonnaise", "cottage cheese or mayonnaise and yogurt");
        substitutions.put("egg", "cornstarch, arrowroot flour, potato starch, egg whites or mashed banana");
        substitutions.put("oil", "applesauce");
        substitutions.put("white bread", "whole-grain bread");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a recipe: ");
        String recipe = scanner.nextLine();
        System.out.print("Do you have any health concerns (high cholesterol, high blood pressure, weight loss, gluten allergy)? ");
        String concerns = scanner.nextLine();
        scanner.close();

        System.out.println("Original recipe: " + recipe);
        System.out.println("Healthier version: " + getHealthierRecipe(recipe, concerns));
        System.out.println("Always consult your physician before making significant changes to your diet.");
    }

    private static String getHealthierRecipe(String recipe, String concerns) {
        String[] ingredients = recipe.split(",");
        StringBuilder healthierRecipe = new StringBuilder();

        for (String ingredient : ingredients) {
            ingredient = ingredient.trim().toLowerCase();
            if (concerns.contains("high cholesterol") && (ingredient.contains("egg") || ingredient.contains("dairy"))) {
                healthierRecipe.append(getSubstitution(ingredient)).append(", ");
            } else if (concerns.contains("weight loss") && ingredient.contains("sugar")) {
                healthierRecipe.append(getSubstitution(ingredient)).append(", ");
            } else if (concerns.contains("gluten allergy") && ingredient.contains("flour")) {
                healthierRecipe.append(getGlutenFreeSubstitution(ingredient)).append(", ");
            } else {
                healthierRecipe.append(ingredient).append(", ");
            }
        }

        return healthierRecipe.toString().replaceAll(", $", "");
    }

    private static String getSubstitution(String ingredient) {
        for (Map.Entry<String, String> entry : substitutions.entrySet()) {
            if (ingredient.contains(entry.getKey())) {
                return ingredient.replace(entry.getKey(), entry.getValue());
            }
        }
        return ingredient;
    }

    private static String getGlutenFreeSubstitution(String ingredient) {
        return ingredient.replace("flour", "rice flour or gluten-free flour");
    }
}
