package liangMultiArrays;

public class ComputeWeeklyHours {
    public static void main(String[] args) {
        int[][] hours = {
                {2, 4, 3, 4, 5, 8, 8},
                {7, 3, 4, 3, 3, 4, 4},
                {3, 3, 4, 3, 3, 2, 2},
                {9, 3, 4, 7, 3, 4, 1},
                {3, 5, 4, 3, 6, 3, 8},
                {3, 4, 4, 6, 3, 4, 4},
                {3, 7, 4, 8, 3, 8, 4},
                {6, 3, 5, 9, 2, 7, 9}
        };

        // Calculate total hours for each employee
        int[] totalHours = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            for (int j = 0; j < hours[i].length; j++) {
                totalHours[i] += hours[i][j];
            }
        }

        // Sort employees by total hours in decreasing order
        Integer[] indices = new Integer[hours.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        java.util.Arrays.sort(indices, (a, b) -> totalHours[b] - totalHours[a]);

        // Display employees and their total hours
        for (int i = 0; i < indices.length; i++) {
            System.out.println("Employee " + indices[i] + "'s total hours: " + totalHours[indices[i]]);
        }
    }

}
