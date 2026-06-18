import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows <= 0) {
            return result;
        }

        List<Integer> previousRow = new ArrayList<>();
        previousRow.add(1);
        result.add(previousRow);

        for (int i = 0; i < numRows - 1; i++) {
            List<Integer> currentRow = new ArrayList<>();
            currentRow.add(1);

            for (int j = 0; j < previousRow.size() - 1; j++) {
                currentRow.add(previousRow.get(j + 1) + previousRow.get(j));
            }

            currentRow.add(1);
            result.add(currentRow);
            previousRow = currentRow;
        }

        return result;
    }

    public static void main(String[] args) {
        PascalTriangle pt = new PascalTriangle();
        int numRows = 5;

        List<List<Integer>> triangle = pt.generate(numRows);

        for (List<Integer> row : triangle) {
            System.out.println(row);
        }
    }
}
