package mathsClasses;

public class GeographyArea {
    public static void main(String[] args) {
        // GPS locations (latitude and longitude) for each city
        double atlantaLat = Math.toRadians(33.7489);
        double atlantaLon = Math.toRadians(-84.3879);
        double orlandoLat = Math.toRadians(28.5383);
        double orlandoLon = Math.toRadians(-81.3789);
        double savannahLat = Math.toRadians(32.0835);
        double savannahLon = Math.toRadians(-81.0833);
        double charlotteLat = Math.toRadians(35.2271);
        double charlotteLon = Math.toRadians(-80.8431);

        // Calculate distances between each pair of cities
        double atlantaOrlando = greatCircleDistance(atlantaLat, atlantaLon, orlandoLat, orlandoLon);
        double atlantaSavannah = greatCircleDistance(atlantaLat, atlantaLon, savannahLat, savannahLon);
        double atlantaCharlotte = greatCircleDistance(atlantaLat, atlantaLon, charlotteLat, charlotteLon);
        double orlandoSavannah = greatCircleDistance(orlandoLat, orlandoLon, savannahLat, savannahLon);
        double orlandoCharlotte = greatCircleDistance(orlandoLat, orlandoLon, charlotteLat, charlotteLon);
        double savannahCharlotte = greatCircleDistance(savannahLat, savannahLon, charlotteLat, charlotteLon);

        // Divide polygon into two triangles and calculate area of each
        double triangle1Area = triangleArea(atlantaOrlando, atlantaSavannah, orlandoSavannah);
        double triangle2Area = triangleArea(atlantaSavannah, atlantaCharlotte, savannahCharlotte);

        // Add areas of two triangles to get total estimated area
        double totalArea = triangle1Area + triangle2Area;

        System.out.printf("Estimated area enclosed by the four cities: %.2f km²", totalArea);
    }

    // Method to calculate great circle distance between two cities
    public static double greatCircleDistance(double lat1, double lon1, double lat2, double lon2) {
        double radius = 6371.01; // Earth's radius in kilometers
        return radius * Math.acos(Math.sin(lat1) * Math.sin(lat2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2));
    }

    // Method to calculate area of a triangle using Heron's formula
    public static double triangleArea(double a, double b, double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

}
