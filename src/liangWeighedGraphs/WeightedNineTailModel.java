package liangWeighedGraphs;

import java.util.*;

public class WeightedNineTailModel {
    public static final int NUMBER_OF_NODES = 512;
    private WeightedGraph2<Integer> graph;

    public WeightedNineTailModel() {
        List<WeightedEdge2> edges = createEdges();
        graph = new WeightedGraph2<Integer>(edges, NUMBER_OF_NODES);
    }

    /** Build the edges with weights = 3 × number of flips */
    private List<WeightedEdge2> createEdges() {
        List<WeightedEdge2> edges = new ArrayList<>();

        for (int u = 0; u < NUMBER_OF_NODES; u++) {
            char[] node = getNode(u);

            for (int k = 0; k < 9; k++) {
                if (node[k] == 'H') {
                    int v = getFlippedNode(node, k);
                    int numberOfFlips = getNumberOfFlips(k);
                    int weight = 3 * numberOfFlips;
                    edges.add(new WeightedEdge2(v, u, weight));
                }
            }
        }
        return edges;
    }

    /** Return shortest path from given node to target (511) */
    public List<Integer> getShortestPath(int nodeIndex) {
        WeightedGraph2<Integer>.ShortestPathTree tree = graph.getShortestPath(511);
        return tree.getPath(nodeIndex);
    }

    /** Print the coin configuration path */
    public void printPath(List<Integer> path) {
        for (int i = path.size() - 1; i >= 0; i--) {
            printNode(getNode(path.get(i)));
            System.out.println();
        }
    }

    // --- Utility methods (same as your version) ---

    private static char[] getNode(int index) {
        char[] result = new char[9];
        for (int i = 0; i < 9; i++) {
            result[i] = (index % 2 == 0) ? 'H' : 'T';
            index /= 2;
        }
        return result;
    }

    private static int getFlippedNode(char[] node, int position) {
        int[] flip = getFlip(position);
        char[] newNode = node.clone();

        for (int i = 0; i < flip.length; i++) {
            if (flip[i] == 1)
                newNode[i] = (newNode[i] == 'H') ? 'T' : 'H';
        }

        return getIndex(newNode);
    }

    private static int getNumberOfFlips(int position) {
        int[] flip = getFlip(position);
        int count = 0;
        for (int f : flip)
            if (f == 1) count++;
        return count;
    }

    private static int getIndex(char[] node) {
        int result = 0;
        for (int i = 8; i >= 0; i--)
            result = result * 2 + ((node[i] == 'T') ? 1 : 0);
        return result;
    }

    private static int[] getFlip(int position) {
        int[] result = new int[9];
        int row = position / 3;
        int column = position % 3;

        flipACell(result, row, column);
        flipACell(result, row - 1, column);
        flipACell(result, row + 1, column);
        flipACell(result, row, column - 1);
        flipACell(result, row, column + 1);

        return result;
    }

    private static void flipACell(int[] result, int row, int column) {
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2)
            result[row * 3 + column] = 1;
    }

    private static void printNode(char[] node) {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0) System.out.println();
            System.out.print(node[i] + " ");
        }
        System.out.println();
    }
//    public WeightedGraph2<Integer>.ShortestPathTree getTree(int root) {
//        return graph.getShortestPath(root);
//    }
    public int getNumberOfVertices() {
        return NUMBER_OF_NODES;
    }
    public WeightedGraph2<Integer>.ShortestPathTree getTree(int nodeIndex) {
        // Return the Dijkstra shortest path tree rooted at the target (511)
        return graph.getShortestPath(nodeIndex);
    }



}
