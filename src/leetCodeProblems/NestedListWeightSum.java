package leetCodeProblems;
import java.util.*;

// This is the interface provided by LeetCode
interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    List<NestedInteger> getList();
}

class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        if (nestedList == null || nestedList.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (NestedInteger entry : nestedList) {
            if (entry.isInteger()) {
                sum += entry.getInteger() * depth;
            } else {
                sum += helper(entry.getList(), depth + 1);
            }
        }
        return sum;
    }

    // Simple implementation of NestedInteger for testing in main
    static class NI implements NestedInteger {
        private Integer val;
        private List<NestedInteger> list;

        NI(int val) { this.val = val; }
        NI(List<NestedInteger> list) { this.list = list; }

        public boolean isInteger() { return val!= null; }
        public Integer getInteger() { return val; }
        public List<NestedInteger> getList() { return list; }
    }

    public static void main(String[] args) {
        NestedListWeightSum solver = new NestedListWeightSum();

        // Test case: [[1,1],2,[1,1]] → 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10
        List<NestedInteger> test1 = Arrays.asList(
                new NI(Arrays.asList(new NI(1), new NI(1))),
                new NI(2),
                new NI(Arrays.asList(new NI(1), new NI(1)))
        );
        System.out.println("depthSum = " + solver.depthSum(test1)); // 10

        // Test case: [1,[4,[6]]] → 1*1 + 4*2 + 6*3 = 27
        List<NestedInteger> test2 = Arrays.asList(
                new NI(1),
                new NI(Arrays.asList(
                        new NI(4),
                        new NI(Arrays.asList(new NI(6)))
                ))
        );
        System.out.println("depthSum = " + solver.depthSum(test2)); // 27
    }
}