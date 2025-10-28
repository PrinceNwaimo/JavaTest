package liangWeighedGraphs;

import liangGraphs.AbstractGraph;

public class WeightedEdge extends AbstractGraph.Edge implements Comparable<WeightedEdge2>{
    public double weight; // The weight on edge (u, v)
/** Create a weighted edge on (u, v) */
public WeightedEdge(int u, int v, double weight) {
         super(u, v);
         this.weight = weight;
            }
@Override /** Compare two edges on weights */
 public int compareTo(WeightedEdge2 edge) {
         if (weight > edge.weight)
             return 1;
         else if (weight == edge.weight)
             return 0;
         else
         return-1;
            }
}
