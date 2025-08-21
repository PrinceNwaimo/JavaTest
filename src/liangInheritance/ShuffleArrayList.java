package liangInheritance;

import java.util.ArrayList;
import java.util.Random;

public class ShuffleArrayList {
    public static void shuffle(ArrayList<Integer> list) {
        Random random = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.println("Before shuffling: " + list);
        shuffle(list);
        System.out.println("After shuffling: " + list);
    }
}
