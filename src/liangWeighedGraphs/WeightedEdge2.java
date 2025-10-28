package liangWeighedGraphs;

import liangGraphs.AbstractGraph4;

public class WeightedEdge2 extends AbstractGraph4.Edge implements Comparable<WeightedEdge2> {
    public double weight;

    public WeightedEdge2(int u, int v, double weight) {
        super(u, v);
        this.weight = weight;
    }

    @Override
    public int compareTo(WeightedEdge2 other) {
        return Double.compare(this.weight, other.weight);
    }
}

