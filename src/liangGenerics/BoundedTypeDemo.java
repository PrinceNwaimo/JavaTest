package liangGenerics;

import liangChapter9.Rectangle;
import liangInheritance.Circle;
import liangInheritance.GeometricObject;


public class BoundedTypeDemo {
    public static void main(String[] args ) {
              Rectangle rectangle = new Rectangle(2, 2);
              Circle circle = new Circle(2);

              System.out.println("Same area? " + equalArea(rectangle, circle));
            }

    private static String equalArea(Rectangle rectangle, Circle circle) {
        return "rectangle";
    }

    public static <E extends GeometricObject> boolean equalArea(E object1, E object2) {
        return object1.getArea() == object2.getArea();
            }
}
