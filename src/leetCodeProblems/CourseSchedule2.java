package leetCodeProblems;
import java.util.*;

public class CourseSchedule2 {
    private boolean hasCycle = false;

    public List<Integer> findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 && numCourses > 0) {
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                result.add(i);
            }
            return result;
        } else if (prerequisites.length == 0 && numCourses == 0) {
            return new ArrayList<>();
        } else {
            DirectedGraph g = new DirectedGraph();
            // prerequisites[i] = [course, prereq] means prereq -> course
            for (int[] entry : prerequisites) {
                g.addEdge(entry[1], entry[0], 1);
            }
            // Add isolated vertices that have no edges
            for (int i = 0; i < numCourses; i++) {
                if (g.getVertex(i) == null) {
                    g.addVertex(i);
                }
            }
            return topSort(g);
        }
    }

    private List<Integer> topSort(DirectedGraph g) {
        if (g.getVertices().isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> topologicalList = new ArrayList<>();
        Queue<Vertex4> topologicalQueue = new LinkedList<>();

        for (Vertex4 node : g) {
            if (node.getIndegree() == 0) {
                topologicalQueue.offer(node);
            }
        }

        while (!topologicalQueue.isEmpty()) {
            Vertex4 currentNode = topologicalQueue.poll();
            topologicalList.add(currentNode.getVertexID());

            for (Vertex4 neighbor : currentNode.getConnections()) {
                neighbor.setIndegree(neighbor.getIndegree() - 1);
                if (neighbor.getIndegree() == 0) {
                    topologicalQueue.offer(neighbor);
                }
            }
        }

        if (topologicalList.size()!= g.getVertices().size()) {
            this.hasCycle = true;
        }
        return topologicalList;
    }

    public static void main(String[] args) {
        CourseSchedule2 solver = new CourseSchedule2();

        int numCourses = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        System.out.println(solver.findOrder(numCourses, prerequisites)); // [0,1,2,3] or [0,2,1,3]

        System.out.println(solver.findOrder(2, new int[][]{{1,0}})); // [0,1]

        System.out.println(solver.findOrder(3, new int[][]{{1,0}})); // [0,1,2] or [0,2,1]

        System.out.println(solver.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})); // same as first
    }
}
