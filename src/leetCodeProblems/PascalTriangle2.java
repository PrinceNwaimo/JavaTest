package leetCodeProblems;
import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0) {
            return new ArrayList<>();
        }
        if (rowIndex == 0) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            return row;
        }

        List<Integer> pre = new ArrayList<>();
        pre.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for (int j = 0; j < pre.size() - 1; j++) {
                curr.add(pre.get(j) + pre.get(j + 1));
            }

            curr.add(1);
            pre = curr;
        }

        return pre;
    }

    public static void main(String[] args) {
        PascalTriangle2 pt2 = new PascalTriangle2();

        int rowIndex = 3;
        List<Integer> row = pt2.getRow(rowIndex);

        System.out.println("Row " + rowIndex + ": " + row);
    }
}
