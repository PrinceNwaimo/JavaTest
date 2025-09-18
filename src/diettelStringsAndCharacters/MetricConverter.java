package diettelStringsAndCharacters;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MetricConverter {
    private static final Map<String, Double> conversions = new HashMap<>();
    private static final Map<String, String> unitTypes = new HashMap<>();

    static {
        // Length conversions
        conversions.put("meter", 1.0);
        conversions.put("centimeter", 0.01);
        conversions.put("millimeter", 0.001);
        conversions.put("kilometer", 1000.0);
        conversions.put("inch", 0.0254);
        conversions.put("foot", 0.3048);
        conversions.put("yard", 0.9144);
        conversions.put("mile", 1609.34);

        unitTypes.put("meter", "length");
        unitTypes.put("centimeter", "length");
        unitTypes.put("millimeter", "length");
        unitTypes.put("kilometer", "length");
        unitTypes.put("inch", "length");
        unitTypes.put("foot", "length");
        unitTypes.put("yard", "length");
        unitTypes.put("mile", "length");

        // Volume conversions
        conversions.put("liter", 1.0);
        conversions.put("milliliter", 0.001);
        conversions.put("gallon", 3.78541);
        conversions.put("quart", 0.946353);
        conversions.put("pint", 0.473176);
        conversions.put("ounce", 0.0295735);

        unitTypes.put("liter", "volume");
        unitTypes.put("milliliter", "volume");
        unitTypes.put("gallon", "volume");
        unitTypes.put("quart", "volume");
        unitTypes.put("pint", "volume");
        unitTypes.put("ounce", "volume");

        // Mass conversions
        conversions.put("gram", 1.0);
        conversions.put("kilogram", 1000.0);
        conversions.put("milligram", 0.001);
        conversions.put("pound", 453.592);
        conversions.put("ounce", 28.3495);

        unitTypes.put("gram", "mass");
        unitTypes.put("kilogram", "mass");
        unitTypes.put("milligram", "mass");
        unitTypes.put("pound", "mass");
        unitTypes.put("ounce", "mass");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a conversion question (e.g., 'How many inches are in 2 meters?'): ");
        String question = scanner.nextLine();
        scanner.close();

        String[] parts = question.split("\\s+");
        if (parts.length != 7 || !parts[0].equalsIgnoreCase("How") || !parts[1].equalsIgnoreCase("many") || !parts[5].equalsIgnoreCase("in")) {
            System.out.println("Invalid question format.");
            return;
        }

        String unit1 = parts[2].toLowerCase();
        String unit2 = parts[6].replace("?", "").toLowerCase();
        double value = Double.parseDouble(parts[4]);

        if (!unitTypes.containsKey(unit1) || !unitTypes.containsKey(unit2)) {
            System.out.println("Unknown unit.");
            return;
        }

        if (!unitTypes.get(unit1).equals(unitTypes.get(unit2))) {
            System.out.println("Invalid conversion.");
            return;
        }

        double result = value * conversions.get(unit2) / conversions.get(unit1);
        System.out.println(parts[4] + " " + parts[2] + " is equal to " + result + " " + parts[6].replace("?", ""));
    }
}
