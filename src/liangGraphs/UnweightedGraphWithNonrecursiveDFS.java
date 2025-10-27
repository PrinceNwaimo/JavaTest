package liangGraphs;
import java.util.*;

public class UnweightedGraphWithNonrecursiveDFS<V> extends UnweightedGraph<V> {

    public UnweightedGraphWithNonrecursiveDFS(List<Edge> edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    @Override
    public Tree dfs(int v) {
        boolean[] visited = new boolean[getSize()];
        List<Integer> searchOrder = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(v);
        while (!stack.isEmpty()) {
            int current = stack.pop();
            if (!visited[current]) {
                visited[current] = true;
                searchOrder.add(current);

                // Push neighbors in reverse order for consistency with recursive DFS
                List<AbstractGraph.Edge> neighborsList = neighbors.get(current);

                // Push in reverse order for same order as recursive DFS
                for (int i = neighborsList.size() - 1; i >= 0; i--) {
                    int neighbor = neighborsList.get(i).v; // get neighbor vertex
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return new Tree(v, searchOrder);
    }
}

//Algorithm NonRecursiveDFS(graph, startVertex):
//    create an empty stack S
//    create a set or array visited[graph.size] initialized to false
//
//    push startVertex onto S
//
//    while S is not empty:
//        vertex = S.pop()
//
//        if vertex is not visited:
//            mark vertex as visited
//            process vertex (e.g., print it)
//
//            for each neighbor in graph.getNeighbors(vertex) in reverse order:
//                if neighbor is not visited:
//                    push neighbor onto S
