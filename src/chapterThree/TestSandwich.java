package chapterThree;

public class TestSandwich {
    static Sandwich food = new Sandwich();

    public static void main(String[] args) {
        System.out.println(make());
    }
    private static String make(){
        food.getBreadType("Wheat");
        return "wheat";
    }
}
