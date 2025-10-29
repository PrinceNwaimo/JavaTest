package liangWeighedGraphs;


import java.util.*;

public class CompareNineTailModels {
    public static final int NUMBER_OF_NODES = 512;

    public static void main(String[] args) {
        // Unweighted version
        NineTailModel unweightedModel = new NineTailModel();
        int[] parent1 = new int[]{unweightedModel.getTree(511).getParent(512)};

        // Weighted version
        WeightedNineTailModel weightedModel = new WeightedNineTailModel();
        int[] parent2 = new int[]{weightedModel.getTree(511).getParent(512)};

        // Compare depths
        int[] depth1 = getDepths(parent1);
        int[] depth2 = getDepths(parent2);

        boolean same = true;
        for (int i = 0; i < NUMBER_OF_NODES; i++) {
            if (depth1[i] != depth2[i]) {
                System.out.printf("❌ Mismatch at node %d: depth1=%d, depth2=%d%n",
                        i, depth1[i], depth2[i]);
                same = false;
            }
        }

        if (same)
            System.out.println("✅ Both NineTailModel and WeightedNineTailModel produce the same shortest paths.");
        else
            System.out.println("❌ They produce different shortest paths.");
    }

    /** Compute depth (distance from target) for each node */
    public static int[] getDepths(int[] parent) {
        int[] depth = new int[NUMBER_OF_NODES];
        for (int i = 0; i < NUMBER_OF_NODES; i++) {
            int d = 0, p = i;
            while (parent[p] != -1) {
                d++;
                p = parent[p];
            }
            depth[i] = d;
        }
        return depth;
    }
}

