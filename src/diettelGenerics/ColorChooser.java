package diettelGenerics;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ColorChooser {
    private static final Map<String, Color> COLORS = new HashMap<>();

    static {
        COLORS.put("BLACK", Color.BLACK);
        COLORS.put("BLUE", Color.BLUE);
        COLORS.put("CYAN", Color.CYAN);
        COLORS.put("DARK_GRAY", Color.DARK_GRAY);
        COLORS.put("GRAY", Color.GRAY);
        COLORS.put("GREEN", Color.GREEN);
        COLORS.put("LIGHT_GRAY", Color.LIGHT_GRAY);
        COLORS.put("MAGENTA", Color.MAGENTA);
        COLORS.put("ORANGE", Color.ORANGE);
        COLORS.put("PINK", Color.PINK);
        COLORS.put("RED", Color.RED);
        COLORS.put("WHITE", Color.WHITE);
        COLORS.put("YELLOW", Color.YELLOW);
    }

    public static Color getColor(String colorName) {
        return COLORS.get(colorName.toUpperCase());
    }

    public static String[] getColorNames() {
        return COLORS.keySet().toArray(new String[0]);
    }
}
