package liangBigONotation;

public class DivideAndConquer {
    public static void main(String[] args) {
        int[] list = {30, 5, 10, 9, 20, 8, 4, 7, 6};
        System.out.println("Smallest number: " + findSmallest(list, 0, list.length - 1));
    }

    public static int findSmallest(int[] list, int low, int high) {
        if (low == high) {
            return list[low];
        } else if (low + 1 == high) {
            return Math.min(list[low], list[high]);
        } else {
            int mid = (low + high) / 2;
            int leftMin = findSmallest(list, low, mid);
            int rightMin = findSmallest(list, mid + 1, high);
            return Math.min(leftMin, rightMin);
        }
    }
}
