package leetCodeProblems;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        Graph2 graph = new Graph2();
        for (int[] entry : prerequisites) {
            graph.addEdge(entry[1], entry[0], 0); // course entry[0] depends on entry[1]
        }

        DFS dfs = new DFS(graph);
        dfs.dfs();
        return!dfs.hasCycle;
    }

    public static void main(String[] args) {
        CourseSchedule solution = new CourseSchedule();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}})); // true
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}, {0, 1}})); // false
    }
}
