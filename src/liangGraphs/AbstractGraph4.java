package liangGraphs;

import java.util.*;

public abstract class AbstractGraph4<V> implements Graph<V> {
    protected List<V> vertices = new ArrayList<>();
    protected List<List<Integer>> neighbors = new ArrayList<>();

    @Override
    public List<Integer> getHamiltonianCycle() {
        List<Integer> path = new ArrayList<>();
        path.add(0); // start from vertex 0

        if (findHamiltonianCycle(0, path)) {
            return path;
        }

        return null;
    }

    private boolean findHamiltonianCycle(int current, List<Integer> path) {
        if (path.size() == vertices.size()) {
            // Check if last vertex connects to the start to form a cycle
            if (neighbors.get(current).contains(path.get(0))) {
                path.add(path.get(0)); // complete cycle
                return true;
            }
            return false;
        }

        for (int next : neighbors.get(current)) {
            if (!path.contains(next)) {
                path.add(next);
                if (findHamiltonianCycle(next, path)) {
                    return true;
                }
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}

