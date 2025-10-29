package liangWeighedGraphs;

public class NineTailWeighted {
    public static final int NUMBER_OF_NODES = 512; // 2^9 possible states

    public static void main(String[] args) {
        WeightedNineTailModel model = new WeightedNineTailModel();
        System.out.println("The number of nodes is " + model.getNumberOfVertices());
        System.out.println("The shortest path from the all-tails state to the all-heads state:");
        java.util.List<Integer> path = model.getShortestPath(511); // all heads
        model.printPath(path);
    }
}

