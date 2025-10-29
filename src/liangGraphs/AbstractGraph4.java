package liangGraphs;

import java.util.*;

public  class AbstractGraph4<V> implements Grapher<V> {
    protected List<V> vertices = new ArrayList<>(); // Store vertices
    protected List<List<AbstractGraph4.Edge>> neighbors  = new ArrayList<>(); // Adjacency lists
    /** Construct an empty graph */
    protected AbstractGraph4() {
    }

    /** Construct a graph from vertices and edges stored in arrays */
    protected AbstractGraph4(V[] vertices, int[][] edges) {
        for (int i = 0; i < vertices.length; i++)
            addVertex(vertices[i]);

        createAdjacencyLists(edges, vertices.length);
    }

    /** Construct a graph from vertices and edges stored in List */
    protected AbstractGraph4(List<V> vertices, List<AbstractGraph.Edge> edges) {
        for (int i = 0; i < vertices.size(); i++)
            addVertex(vertices.get(i));

        createAdjacencyLists(edges, vertices.size());
    }

    /** Construct a graph for integer vertices 0, 1, 2 and edge list */
    protected AbstractGraph4(List<AbstractGraph.Edge> edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            addVertex((V)(new Integer(i))); // vertices is {0, 1, ...}

        createAdjacencyLists(edges, numberOfVertices);
    }

    /** Construct a graph from integer vertices 0, 1, and edge array */
    protected AbstractGraph4(int[][] edges, int numberOfVertices) {
        for (int i = 0; i < numberOfVertices; i++)
            addVertex((V)(new Integer(i))); // vertices is {0, 1, ...}

        createAdjacencyLists(edges, numberOfVertices);
    }

    public AbstractGraph4(List<Displayable2> vertices, int[][] edges) {
        super();
    }

    /** Create adjacency lists for each vertex */
    private void createAdjacencyLists(
            int[][] edges, int numberOfVertices) {
        for (int i = 0; i < edges.length; i++) {
            addEdge(edges[i][0], edges[i][1]);
        }
    }

    /** Create adjacency lists for each vertex */
    private void createAdjacencyLists(
            List<AbstractGraph.Edge> edges, int numberOfVertices) {
        for (AbstractGraph.Edge edge: edges) {
            addEdge(edge.u, edge.v);
        }
    }

    @Override /** Return the number of vertices in the graph */
    public int getSize() {
        return vertices.size();
    }

    @Override /** Return the vertices in the graph */
    public List<V> getVertices() {
        return vertices;
    }

    @Override /** Return the object for the specified vertex */
    public V getVertex(int index) {
        return vertices.get(index);
    }
    @Override /** Return the index for the specified vertex object */
    public int getIndex(V v) {
        return vertices.indexOf(v);
    }

    @Override /** Return the neighbors of the specified vertex */
    public List<Integer> getNeighbors(int index) {
        List<Integer> result = new ArrayList<>();
        for (AbstractGraph4.Edge e: neighbors.get(index))
            result.add(e.v);

        return result;
    }

    @Override /** Return the degree for a specified vertex */
    public int getDegree(int v) {
        return neighbors.get(v).size();
    }

    @Override /** Print the edges */
    public void printEdges() {
        for (int u = 0; u < neighbors.size(); u++) {
            System.out.print(getVertex(u) + " (" + u + "): ");
            for (AbstractGraph4.Edge e: neighbors.get(u)) {
                System.out.print("(" + getVertex(e.u) + ", " +  getVertex(e.v) + ") ");
            }
            System.out.println();
        }
    }

    @Override /** Clear the graph */
    public void clear() {
        vertices.clear();
        neighbors.clear();
    }

    @Override /** Add a vertex to the graph */
    public boolean addVertex(V vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
            neighbors.add(new ArrayList<AbstractGraph4.Edge>());
            return true;
        }
        else {
            return false;
        }
    }

    /** Add an edge to the graph */
    protected boolean addEdge(AbstractGraph4.Edge e) {
        if (e.u < 0 || e.u > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.u);

        if (e.v < 0 || e.v > getSize() - 1)
            throw new IllegalArgumentException("No such index: " + e.v);
        if (!neighbors.get(e.u).contains(e)) {
            neighbors.get(e.u).add(e);
            return true;
        }
        else {
            return false;
        }
    }
    @Override /** Add an edge to the graph */
    public boolean addEdge(int u, int v) {
        return addEdge(new AbstractGraph4.Edge(u, v));
    }

    /** Edge inner class inside the AbstractGraph class */
    public static class Edge {
        public int u; // Starting vertex of the edge
        public int v; // Ending vertex of the edge

        /** Construct an edge for (u, v) */
        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }

        public boolean equals(Object o) {
            return u == ((AbstractGraph.Edge)o).u && v == ((AbstractGraph.Edge)o).v;
        }
    }

    @Override /** Obtain a DFS tree starting from vertex v */
    /** To be discussed in Section 28.7 */
    public Tree dfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1; // Initialize parent[i] to -1

        // Mark visited vertices
        boolean[] isVisited = new boolean[vertices.size()];

        // Recursively search
        dfs(v, parent, searchOrder, isVisited);

        // Return a search tree
        return new AbstractGraph4.Tree(v, searchOrder,parent);
    }

    /** Recursive method for DFS search */
    private void dfs(int u, int[] parent, List<Integer> searchOrder,
                     boolean[] isVisited) {
        // Store the visited vertex
        searchOrder.add(u);
        isVisited[u] = true; // Vertex v visited

        for (AbstractGraph4.Edge e : neighbors.get(u)) {
            if (!isVisited[e.v]) {
                parent[e.v] = u; // The parent of vertex e.v is u
                dfs(e.v, parent, searchOrder, isVisited); // Recursive search
            }
        }
    }
    @Override /** Starting bfs search from vertex v */
    /** To be discussed in Section 28.9 */
    public Tree bfs(int v) {
        List<Integer> searchOrder = new ArrayList<>();
        int[] parent = new int[vertices.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = -1;// Initialize parent[i] to -1
        java.util.LinkedList<Integer> queue = new java.util.LinkedList<>(); // list used as a queue
        boolean[] isVisited = new boolean[vertices.size()];
        queue.offer(v); // Enqueue v
        isVisited[v] = true;// Mark it visited

        while (!queue.isEmpty()) {
            int u = queue.poll(); // Dequeue to u
            searchOrder.add(u); // u searched
            for (AbstractGraph4.Edge e: neighbors.get(u)) {
                if (!isVisited[e.v]) {
                    queue.offer(e.v); // Enqueue w
                    parent[e.v] = u; // The parent of w is u
                    isVisited[e.v] = true;// Mark it visited
                }
            }
        }

        return new AbstractGraph4.Tree(v, searchOrder,parent);
    }

    /** Tree inner class inside the AbstractGraph class */
    /** To be discussed in Section 28.6 */
    public class Tree {
        private int root; // The root of the tree
        protected int[] parent; // Store the parent of each vertex
        private List<Integer> searchOrder; // Store the search order

        /** Construct a tree with root, parent, and searchOrder */
        public Tree(int root, List<Integer> searchOrder, int[]parent) {
            this.root = root;
            this.parent = parent;
            this.searchOrder = searchOrder;
        }

        /** Return the root of the tree */
        public int getRoot() {
            return root;
        }
        /** Return the parent of vertex v */
        public int getParent(int v) {
            return parent[v];
        }

        /** Return an array representing search order */
        public List<Integer> getSearchOrder() {
            return searchOrder;
        }

        /** Return number of vertices found */
        public int getNumberOfVerticesFound() {
            return searchOrder.size();
        }

        /** Return the path of vertices from a vertex to the root */
        public List<V> getPath(int index) {
            ArrayList<V> path = new ArrayList<>();

            do {
                path.add(vertices.get(index));
                index = parent[index];
            }
            while (index != -1);
            return path;
        }
        /** Print a path from the root to vertex v */
        public void printPath(int index) {
            List<V> path = getPath(index);
            System.out.print("A path from " + vertices.get(root) + " to " +  vertices.get(index) + ": ");
            for (int i = path.size() - 1; i >= 0; i--)
                System.out.print(path.get(i) + " ");
        }
        /** Print the whole tree */
        public void printTree() {
            System.out.println("Root is: " + vertices.get(root));
            System.out.print("Edges: ");
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] != -1) {
                    // Display an edge
                    System.out.print("(" + vertices.get(parent[i]) + ", " +vertices.get(i) + ") ");
                }
            }
            System.out.println();
        }
    }
    public List<Integer> getPath(int u, int v) {
        boolean[] visited = new boolean[getSize()];
        int[] parent = new int[getSize()];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        visited[u] = true;
        queue.offer(u);

        // BFS traversal
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == v) break; // Found destination

            for (AbstractGraph4.Edge edge : neighbors.get(current)) {
                int neighbor = edge.v;
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.offer(neighbor);
                }
            }
        }

        // Reconstruct path from u → v using parent[]
        List<Integer> path = new ArrayList<>();
        for (int at = v; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);

        // If v was unreachable, path will not start with u
        if (path.get(0) != u) {
            return new ArrayList<>(); // return empty list if no path exists
        }

        return path;
    }

    public boolean isCyclic() {
        boolean[] visited = new boolean[getSize()];

        // Check all components
        for (int i = 0; i < getSize(); i++) {
            if (!visited[i]) {
                if (isCyclicDFS(i, visited, -1)) {
                    return true; // Found a cycle
                }
            }
        }
        return false; // No cycles found
    }

    // Helper method for DFS-based cycle detection
    private boolean isCyclicDFS(int current, boolean[] visited, int parent) {
        visited[current] = true;

        for (AbstractGraph4.Edge edge : neighbors.get(current)) {
            int neighbor = edge.v;

            if (!visited[neighbor]) {
                if (isCyclicDFS(neighbor, visited, current))
                    return true;
            } else if (neighbor != parent) {
                // Found a visited vertex that isn’t the parent → cycle
                return true;
            }
        }

        return false;
    }
    public List<Integer> getACycle(int start) {
        boolean[] visited = new boolean[getSize()];
        int[] parent = new int[getSize()];
        Arrays.fill(parent, -1);

        List<Integer> cycle = new ArrayList<>();

        if (dfsFindCycle(start, visited, parent, cycle, -1))
            return cycle;  // found a cycle
        else
            return null;   // no cycle found
    }

    // --- Helper recursive DFS for cycle detection & reconstruction ---
    private boolean dfsFindCycle(int current, boolean[] visited, int[] parent,
                                 List<Integer> cycle, int par) {
        visited[current] = true;

        for (AbstractGraph4.Edge edge : neighbors.get(current)) {
            int neighbor = edge.v;

            if (!visited[neighbor]) {
                parent[neighbor] = current;
                if (dfsFindCycle(neighbor, visited, parent, cycle, current))
                    return true;
            } else if (neighbor != par) {
                // ✅ Found a back-edge → reconstruct cycle
                buildCyclePath(current, neighbor, parent, cycle);
                return true;
            }
        }
        return false;
    }

    // --- Helper to reconstruct the cycle from parent[] info ---
    private void buildCyclePath(int current, int neighbor, int[] parent, List<Integer> cycle) {
        cycle.add(neighbor);
        int temp = current;

        while (temp != neighbor && temp != -1) {
            cycle.add(temp);
            temp = parent[temp];
        }

        // Reverse so cycle starts with first found vertex
        Collections.reverse(cycle);
    }
    public boolean isBipartite() {
        int[] color = new int[vertices.size()];
        Arrays.fill(color, -1); // -1 means uncolored

        for (int start = 0; start < vertices.size(); start++) {
            if (color[start] == -1) {
                // Start BFS for this component
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(start);
                color[start] = 0;

                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (AbstractGraph4.Edge e : neighbors.get(v)) {
                        int u = e.v; // adjacent vertex
                        if (color[u] == -1) {
                            color[u] = 1 - color[v];
                            queue.offer(u);
                        } else if (color[u] == color[v]) {
                            return false; // adjacent vertices with same color
                        }
                    }
                }
            }
        }
        return true; // No conflict found
    }
    public List<List<Integer>> getBipartite() {
        int n = vertices.size();
        int[] color = new int[n];
        Arrays.fill(color, -1);

        List<Integer> setA = new ArrayList<>();
        List<Integer> setB = new ArrayList<>();

        for (int start = 0; start < n; start++) {
            if (color[start] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(start);
                color[start] = 0;

                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (AbstractGraph4.Edge e : neighbors.get(v)) {
                        int u = e.v;
                        if (color[u] == -1) {
                            color[u] = 1 - color[v];
                            queue.offer(u);
                        } else if (color[u] == color[v]) {
                            // Not bipartite
                            return null;
                        }
                    }
                }
            }
        }

        // Divide into sets after coloring
        for (int i = 0; i < n; i++) {
            if (color[i] == 0) {
                setA.add(i);
            } else if (color[i] == 1) {
                setB.add(i);
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(setA);
        result.add(setB);
        return result;
    }



    @Override
    public List<Integer> getHamiltonianCycle() {
        List<Integer> path = new ArrayList<>();
        path.add(0); // start from vertex 0

        if (findHamiltonianCycle(0, path)) {
            return path;
        }

        return null;
    }

//    private boolean findHamiltonianCycle(int current, List<Integer> path) {
//        if (path.size() == vertices.size()) {
//            // Check if last vertex connects to the start to form a cycle
//            if (neighbors.get(current).contains(path.get(0))) {
//                path.add(path.get(0)); // complete cycle
//                return true;
//            }
//            return false;
//        }
//
//        for (int next : neighbors.get(current)) {
//            if (!path.contains(next)) {
//                path.add(next);
//                if (findHamiltonianCycle(next, path)) {
//                    return true;
//                }
//                path.remove(path.size() - 1);
//            }
//        }
//
//        return false;
//    }

    private boolean findHamiltonianCycle(int current, List<Integer> path) {
        if (path.size() == vertices.size()) {
            // Check cycle condition explicitly considering edge existence
            if (hasEdge(current, path.get(0))) {
                path.add(path.get(0)); // Attempt to close cycle
                return true;
            }
            return false;
        }

        for (Edge e : neighbors.get(current)) {
            int next = e.v; // Assuming Edge has 'v' for destination
            if (!path.contains(next)) {
                path.add(next);
                if (findHamiltonianCycle(next,path)) {
                    return true;
                }
                path.remove(path.size() - 1); // Backtrack
            }
        }
        return false;
    }

    // Helper for edge existence check
    private boolean hasEdge(int u, int v) {
        for (Edge e : neighbors.get(u)) {
            if (e.v == v) return true;
        }
        return false;
    }

  
}

