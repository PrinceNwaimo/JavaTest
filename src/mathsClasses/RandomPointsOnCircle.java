package mathsClasses;

import java.util.Random;

public class RandomPointsOnCircle {
    public static void main(String[] args) {
        Random random = new Random();
        double radius = 40;

        // Generate three random points on the circle
        double[] point1 = generateRandomPoint(radius, random);
        double[] point2 = generateRandomPoint(radius, random);
        double[] point3 = generateRandomPoint(radius, random);

        // Calculate the angles in the triangle
        double angle1 = calculateAngle(point1, point2, point3);
        double angle2 = calculateAngle(point2, point3, point1);
        double angle3 = calculateAngle(point3, point1, point2);

        System.out.println("Point 1: (" + point1[0] + ", " + point1[1] + ")");
        System.out.println("Point 2: (" + point2[0] + ", " + point2[1] + ")");
        System.out.println("Point 3: (" + point3[0] + ", " + point3[1] + ")");
        System.out.println("Angle 1: " + Math.toDegrees(angle1) + " degrees");
        System.out.println("Angle 2: " + Math.toDegrees(angle2) + " degrees");
        System.out.println("Angle 3: " + Math.toDegrees(angle3) + " degrees");
    }

    public static double[] generateRandomPoint(double radius, Random random) {
        double angle = random.nextDouble() * 2 * Math.PI;
        double x = radius * Math.cos(angle);
        double y = radius * Math.sin(angle);
        return new double[] {x, y};
    }

    public static double calculateAngle(double[] point1, double[] point2, double[] point3) {
        double a = distance(point2, point3);
        double b = distance(point1, point3);
        double c = distance(point1, point2);
        return Math.acos((a * a + b * b - c * c) / (2 * a * b));
    }

    public static double distance(double[] point1, double[] point2) {
        return Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
    }

}
