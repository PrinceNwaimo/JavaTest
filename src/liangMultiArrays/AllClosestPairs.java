package liangMultiArrays;

public class AllClosestPairs {
    public static void main(String[] args) {
        double[][] points = {
                {-1, 0, 3},
                {-1, -1, -1},
                {4, 1, 1},
                {2, 0.5, 9},
                {3.5, 2, -1},
                {3, 1.5, 3},
                {-1.5, 4, 2},
                {5.5, 4, -0.5},
                {-1, 0, 3} // added another point with same coordinates as the first point
        };

        double shortestDistance = Double.MAX_VALUE;
        StringBuilder closestPairs = new StringBuilder();

        // Compute distance for every two points
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double d = distance(points[i][0], points[i][1], points[i][2],
                        points[j][0], points[j][1], points[j][2]);

                if (d < shortestDistance) {
                    shortestDistance = d;
                    closestPairs = new StringBuilder();
                    closestPairs.append("(").append(points[i][0]).append(", ").append(points[i][1]).append(", ").append(points[i][2]).append(") and (").append(points[j][0]).append(", ").append(points[j][1]).append(", ").append(points[j][2]).append(")\n");
                } else if (d == shortestDistance) {
                    closestPairs.append("(").append(points[i][0]).append(", ").append(points[i][1]).append(", ").append(points[i][2]).append(") and (").append(points[j][0]).append(", ").append(points[j][1]).append(", ").append(points[j][2]).append(")\n");
                }
            }
        }

        // Display result
        System.out.println("The closest pairs of points are:");
        System.out.println(closestPairs.toString());
        System.out.println("The distance is " + shortestDistance);
    }

    public static double distance(
            double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }

}
