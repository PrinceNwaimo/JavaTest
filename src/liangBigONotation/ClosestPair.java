package liangBigONotation;

import java.util.Arrays;

public class ClosestPair {
    public static Pair getClosestPair(double[][] points) {
        Point[] pointArray = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            pointArray[i] = new Point(points[i][0], points[i][1]);
        }
        return getClosestPair(pointArray);
    }

    public static Pair getClosestPair(Point[] points) {
        Point[] pointsOrderedOnX = points.clone();
        Arrays.sort(pointsOrderedOnX, (p1, p2) -> Double.compare(p1.x, p2.x));

        Point[] pointsOrderedOnY = points.clone();
        Arrays.sort(pointsOrderedOnY, new CompareY());

        return distance(pointsOrderedOnX, 0, pointsOrderedOnX.length - 1, pointsOrderedOnY);
    }

    public static Pair distance(Point[] pointsOrderedOnX, int low, int high, Point[] pointsOrderedOnY) {
        if (low == high) {
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[low]);
        }

        int mid = (low + high) / 2;
        Point midPoint = pointsOrderedOnX[mid];

        Pair leftPair = distance(pointsOrderedOnX, low, mid, pointsOrderedOnY);
        Pair rightPair = distance(pointsOrderedOnX, mid + 1, high, pointsOrderedOnY);

        Pair closestPair = leftPair.getDistance() < rightPair.getDistance() ? leftPair : rightPair;

        Point[] stripPoints = getStripPoints(pointsOrderedOnY, midPoint.x, closestPair.getDistance());
        closestPair = getClosestPairInStrip(stripPoints, closestPair);

        return closestPair;
    }

    private static Point[] getStripPoints(Point[] pointsOrderedOnY, double midX, double d) {
        int count = 0;
        for (Point point : pointsOrderedOnY) {
            if (Math.abs(point.x - midX) < d) {
                count++;
            }
        }

        Point[] stripPoints = new Point[count];
        int j = 0;
        for (Point point : pointsOrderedOnY) {
            if (Math.abs(point.x - midX) < d) {
                stripPoints[j++] = point;
            }
        }

        return stripPoints;
    }

    private static Pair getClosestPairInStrip(Point[] stripPoints, Pair closestPair) {
        double minDistance = closestPair.getDistance();
        for (int i = 0; i < stripPoints.length; i++) {
            for (int j = i + 1; j < stripPoints.length && stripPoints[j].y - stripPoints[i].y < minDistance; j++) {
                double distance = distance(stripPoints[i], stripPoints[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPair = new Pair(stripPoints[i], stripPoints[j]);
                }
            }
        }
        return closestPair;
    }

    public static double distance(Point p1, Point p2) {
        return distance(p1.x, p1.y, p2.x, p2.y);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}
