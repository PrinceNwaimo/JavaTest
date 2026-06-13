package leetCodeProblems;

public class TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int maxSeenRight = 0;
        int maxSeenLeft = 0;
        int rainWater = 0;
        int[] maxSeen = new int[n];

        // Pass 1: max height to the right of each index
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] > maxSeenRight) {
                maxSeen[i] = height[i];
                maxSeenRight = height[i];
            } else {
                maxSeen[i] = maxSeenRight;
            }
        }

        // Pass 2: track max from left, calculate trapped water
        for (int i = 0; i < n; i++) {
            if (height[i] > maxSeenLeft) {
                maxSeenLeft = height[i];
            }
            rainWater += Math.max(0, Math.min(maxSeen[i], maxSeenLeft) - height[i]);
        }

        return rainWater;
    }

    public static void main(String[] args) {
        TrappingRainWater solver = new TrappingRainWater();

        int[] height1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height2 = {4,2,0,3,2,5};

        System.out.println(solver.trap(height1));
        System.out.println(solver.trap(height2));
    }
}
