package liangWeighedGraphs;

import liangGraphs.UnweightedGraph3;

public class NineTailModel extends UnweightedGraph3<Integer> {
    public static final int NUMBER_OF_NODES = 512;

    public NineTailModel() {
        // Build the graph of all states
        for (int i = 0; i < NUMBER_OF_NODES; i++)
            addVertex(i);

        for (int i = 0; i < NUMBER_OF_NODES; i++) {
            for (int j = 0; j < 9; j++) {
                int flipped = getFlippedNode(i, j);
                addEdge(flipped, i);
            }
        }
    }

    /** Get BFS tree from node (root) */
    public Tree getTree(int node) {
        return bfs(node);
    }

    /** Flip a coin at position j */
    private int getFlippedNode(int nodeIndex, int position) {
        char[] coins = getNode(nodeIndex);
        flip(coins, position);
        return getIndex(coins);
    }

    private char[] getNode(int index) {
        char[] result = new char[9];
        for (int i = 0; i < 9; i++) {
            result[i] = (index % 2 == 0) ? 'H' : 'T';
            index /= 2;
        }
        return result;
    }

    private void flip(char[] coins, int i) {
        int[] neighbors = {i, i - 1, i + 1, i - 3, i + 3};
        for (int k : neighbors)
            if (k >= 0 && k < 9) coins[k] = (coins[k] == 'H') ? 'T' : 'H';
    }

    private int getIndex(char[] coins) {
        int result = 0;
        for (int i = 0; i < 9; i++)
            if (coins[i] == 'T')
                result += (1 << i);
        return result;
    }
}

