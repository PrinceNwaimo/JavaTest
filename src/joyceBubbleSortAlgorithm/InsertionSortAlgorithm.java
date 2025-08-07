package joyceBubbleSortAlgorithm;

public class InsertionSortAlgorithm {
    public static void main(String[] args) {

        int[] someNums = {90, 85, 65, 95, 75};
        int a, b, temp;
        a = 1;
        while (a < someNums.length) {
            temp = someNums[a];
            b = a - 1;
            while (b >= 0 && someNums[b] > temp) {
                someNums[b + 1] = someNums[b];
                --b;
            }
            someNums[b + 1] = temp;
            ++a;
        }
        display(someNums, 0);
    }
        public static void display(int[] someNums, int a){
            System.out.println("iteration " + a + " : ");
            for (int x = 0; x < someNums.length; ++x) {
                System.out.println(someNums[x] + " ");
                System.out.println();
            }
    }
}
