package liangCollections;

import java.util.Comparator;

public class GeometricObjectSorter {
    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (comparator.compare(list[j], list[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                E temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        GeometricObject[] list = {
                new Circle(5),
                new Rectangle(4, 5),
                new Circle(5.5),
                new Rectangle(2.4, 5),
                new Circle(0.5),
                new Rectangle(4, 65),
                new Circle(4.5),
                new Rectangle(4.4, 1),
                new Circle(6.5),
                new Rectangle(4, 5)
        };

        System.out.println("Before sorting:");
        for (GeometricObject object : list) {
            System.out.println(object);
        }

        selectionSort(list, new GeometricObjectComparator());

        System.out.println("\nAfter sorting:");
        for (GeometricObject object : list) {
            System.out.println(object);
        }
    }
}

class GeometricObject {
    private String color;
    private boolean filled;

    public GeometricObject() {
        this.color = "white";
        this.filled = false;
    }

    public GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "GeometricObject{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}

class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", area=" + getArea() +
                '}';
    }
}

class Rectangle extends GeometricObject {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", area=" + getArea() +
                '}';
    }
}

class GeometricObjectComparator implements Comparator<GeometricObject> {
    @Override
    public int compare(GeometricObject o1, GeometricObject o2) {
        double area1 = 0;
        double area2 = 0;

        if (o1 instanceof Circle) {
            area1 = ((Circle) o1).getArea();
        } else if (o1 instanceof Rectangle) {
            area1 = ((Rectangle) o1).getArea();
        }

        if (o2 instanceof Circle) {
            area2 = ((Circle) o2).getArea();
        } else if (o2 instanceof Rectangle) {
            area2 = ((Rectangle) o2).getArea();
        }

        if (area1 < area2) {
            return -1;
        } else if (area1 > area2) {
            return 1;
        } else {
            return 0;
        }
    }
}
