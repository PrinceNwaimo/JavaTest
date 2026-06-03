package leetCodeProblems;
import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n == 1 && edges.length == 0) {
            return true;
        }
        if (!checkInput(n, edges)) {
            return false;
        }
        if (n == 0 && edges.length > 0) {
            return false;
        }
        if (n == 1 && edges.length >= 1) {
            return false;
        }

        Graph3 g = new Graph3();
        for (int[] entry : edges) {
            g.addEdge(entry[0], entry[1], 1);
        }

        List<Boolean> results = new ArrayList<>();
        for (Vertex3 vertex3 : g) {
            if (vertex3.getColor().equals("white")) {
                results.add(checkValidity(vertex3));
            }
        }

        if (results.size() > 1) {
            return false;
        } else {
            return results.get(0);
        }
    }

    private boolean checkInput(int n, int[][] edges) {
        Set<Integer> vertices = new HashSet<>();
        for (int[] entry : edges) {
            vertices.add(entry[0]);
            vertices.add(entry[1]);
        }
        return vertices.size() == n;
    }

    private boolean checkValidity(Vertex3 start) {
        Stack<Vertex3> stack = new Stack<>();
        start.setColor("gray");
        stack.push(start);

        while (!stack.isEmpty()) {
            Vertex3 currNode = stack.pop();
            for (Vertex3 nbr : currNode.getConnections()) {
                if (nbr.getColor().equals("gray")) {
                    return false; // cycle detected
                }
                if (nbr.getColor().equals("white")) {
                    nbr.setColor("gray");
                    stack.push(nbr);
                }
            }
            currNode.setColor("black");
        }
        return true;
    }

    public static void main(String[] args) {
        GraphValidTree solver = new GraphValidTree();

        int n = 5;
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};

        boolean result = solver.validTree(n, edges);
        System.out.println("Is valid tree? " + result); // true

        int[][] edges2 = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        boolean result2 = solver.validTree(n, edges2);
        System.out.println("Is valid tree? " + result2); // false - has cycle
    }
}
