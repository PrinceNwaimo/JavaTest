package leetCodeProblems;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private Map<Integer, Integer> numMap;

    public TwoSum() {
        numMap = new HashMap<>();
    }

    public void add(int number) {
        numMap.put(number, numMap.getOrDefault(number, 0) + 1);
    }

    public boolean find(int value) {
        if (numMap.isEmpty()) {
            return false;
        }

        for (int num : numMap.keySet()) {
            int target = value - num;
            if (numMap.containsKey(target)) {
                // same number used twice needs count > 1
                if (num != target || numMap.get(target) > 1) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(0);
        twoSum.add(0);
        System.out.println(twoSum.find(0)); // true

        twoSum.add(3);
        twoSum.add(5);
        System.out.println(twoSum.find(8)); // true
        System.out.println(twoSum.find(7)); // false
    }
}
