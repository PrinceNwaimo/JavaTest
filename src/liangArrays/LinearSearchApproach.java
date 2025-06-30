package liangArrays;

public class LinearSearchApproach {
    public static void main(String[] args) {
        int[]list = {1,4,4,2,5,-3,6,2};
        int i = linearSearch(list,-4 );
        System.out.println(i);
    }
    public static int linearSearch(int[] list, int key){
        for (int i = 0; i < list.length; i++) {
            if(key == list[i])
                return i;
        }
        return -1;
    }
}
