package liangArrays;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] list = {2, 4,7,10,11,45,50,59,60,66,69,70,79};

        for (int i = 0; i < list.length - 1; i++) {
            double currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i; j < list.length ; j++) {
                if(currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = (int) currentMin;
            }

        }
    }
}
