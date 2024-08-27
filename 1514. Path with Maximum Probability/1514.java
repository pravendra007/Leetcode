import java.util.*;
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int edge[] = edges[i];
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(new Node(v,succProb[i]));
            adj.get(v).add(new Node(u,succProb[i]));
        }
        double res[] = getMaxProb(start_node,n,adj);
        return res[end_node];
    }
    public double[] getMaxProb(int source,int n,List<List<Node>> adj){
        boolean visited[] = new boolean[n];
        double arr[] = new double[n];

        PriorityQueue<Node> pq = new PriorityQueue<>((Node a1,Node a2)->{
            if(a2.w>a1.w)
            return 1;
            return -1;
        });

        pq.add(new Node(source,1.0));
        visited[source] = true;
        arr[source] = 1.0;

        while(!pq.isEmpty()){
            Node curr = pq.remove();
            for(Node next: adj.get(curr.v)){
                if(!visited[next.v] || curr.w*next.w>arr[next.v]){
                    visited[next.v] = true;
                    arr[next.v] = curr.w*next.w;
                    pq.add(new Node(next.v,arr[next.v]));
                }
            }
        }
        return arr;
    }
}
class Node{
    int v;
    double w;

    Node(int v,double w){
        this.v = v;
        this.w = w;
    }
}