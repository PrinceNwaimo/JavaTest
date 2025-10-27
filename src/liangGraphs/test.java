package liangGraphs;

public class test {
    public static void main(String[] args) {
        int[][] edges1 = {
                {0, 1}, {0, 3}, {1, 2}, {2, 3}
        }; // Not bipartite (contains odd cycle)

        int[][] edges2 = {
                {0, 1}, {0, 3}, {1, 2}
        }; // Bipartite

        MyGraph g1 = new MyGraph(edges1, 4);
        System.out.println("Graph 1 is bipartite? " + g1.isBipartite());

        MyGraph g2 = new MyGraph(edges2, 4);
        System.out.println("Graph 2 is bipartite? " + g2.isBipartite());
    }
}
