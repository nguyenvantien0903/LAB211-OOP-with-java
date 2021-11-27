/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
        
package mygraph;

import java.util.*;
/**
 *
 * @author NVT
 */
class Node implements Comparator<Node> {
	public int node;
	public int cost;

	public Node() {}

	public Node(int node, int cost){
            // This keyword refers to current instance itself
            this.node = node;
            this.cost = cost;
	}
	// Method 1
	@Override public int compare(Node node1, Node node2){
            if (node1.cost < node2.cost)
                    return -1;

            if (node1.cost > node2.cost)
                    return 1;

            return 0;
	}
}


public class MyGraph {
    static int n;
    int a[][];
    char v[];
    
    public MyGraph(){
        v="ABCDEFGHIJKLMN".toCharArray();
    }
    
    void setData(int[][] b){
        n=b.length;
        a=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                a[i][j]=b[i][j];
            }
        }
    }
    
    void display(){
        System.out.println("cac dinh lien ke:");
        for(int i=0;i<n;i++){
            System.out.println(v[i]+":");
            for(int j=0;j<n;j++){
                if(a[i][j]!=0&&a[i][j]!=Integer.MAX_VALUE){
                    System.out.print(v[j]+" ");
                }
            }
            System.out.println("");
        }
    }
    
    public static void dijkstra(int[][] adj, int src){
        PriorityQueue<Node> pq = new PriorityQueue<Node>(n, new Node());
        Set<Integer> settled = new HashSet<Integer>();
        int dist[]=new int[n];
        int pre[]=new int[n];

        for (int i = 0; i < n; i++)
            dist[i] = Integer.MAX_VALUE;

        pq.add(new Node(src, 0));
        
        dist[src] = 0;

        while (settled.size() != n) {
            // Terminating ondition check when
            // the priority queue is empty, return
            if (pq.isEmpty())
                    return;

            // Removing the minimum distance node
            // from the priority queue
            int u = pq.remove().node;

            // Adding the node whose distance is
            // finalized
            if (settled.contains(u))
                // Continue keyword skips exwcution for
                // following check
                continue;
            // We don't have to call e_Neighbors(u)
            // if u is already present in the settled set.
            settled.add(u);

            for(int i=0;i<n;i++){
                if(adj[u][i]==0||adj[u][i]==Integer.MAX_VALUE)continue;
                if(settled.contains(i))continue;
                if(dist[u]+adj[u][i]<dist[i]){
                    dist[i]=dist[u]+adj[u][i];
                    pq.add(new Node(i,dist[i]));
                    pre[i]=u;
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println(dist[i]+" ");
        }
        
        for(int i=0;i<n;i++){
            Stack<Integer> s=new Stack<Integer>();
            int st=i;
            s.push(st);
            while(st!=src){
                st=pre[st];
                s.push(st);
            }
            while(!s.isEmpty()){
                System.out.print(s.pop()+"->");
            }
            System.out.println("");
        }
    }
    
    public static void bfs(int[][] adj,int src,int n){
        int[] settled = new int[n];
        Queue<Integer> mq = new LinkedList<Integer>();
        settled.add(src);
        mq.add(src);
        while(!mq.isEmpty()){
            System.out.print(mq.peek()+" ");
            int x=mq.poll();
            for(int i=0;i<n;i++){
                if(adj[x][i]==0||adj[x][i]==Integer.MAX_VALUE)continue;
                if (settled.contains(i))continue;
                settled.add(i);
                mq.add(i);
            }
        }
        System.out.println("");
    }
    
    public int countCom() {
        int count = 0;
        boolean visited[] = new boolean[n];
        for (int j = 0; j < n; j++) {
            visited[j] = false;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(a, visited, i, false);
                count++;
            }
        }
        return count;
    }

    public void cutedge() {
        int com = countCom();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i][j] != 0) {
                    a[i][j] = a[j][i] = 0;
                    if (countCom() > com) {
                        System.out.println(label[i] + " - " + label[j]);
                    }
                    a[i][j] = 1;
                    a[j][i] = 1;
                }
            }
        }
    }

    public int[] addX(int n, int arr[], int x) {
        int i;
        int newarr[] = new int[n + 1];
        for (i = 0; i < n; i++) {
            newarr[i] = arr[i];
        }
        newarr[n] = x;
        return newarr;
    }

    public void cutvertice() {
        int com = countCom();
        for (int i = 0; i < label.length; i++) {
            int[] index = new int[0];
            for (int j = 0; j < label.length; j++) {
                if (a[i][j] != 0) {
                    a[i][j] = a[j][i] = 0;
                    index = addX(index.length, index, j);
                }
            }
            if (countCom() > com + 1) {
                System.out.print(label[i] + " ");
            }
            for (int j = 0; j < index.length; j++) {
                int l = index[j];
                a[i][l] = a[l][i] = 1;
            }
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        int[][] c = {
            {0,   7,   9, Integer.MAX_VALUE, Integer.MAX_VALUE, 14},
            {7,   0, 10, 15, Integer.MAX_VALUE, Integer.MAX_VALUE},
            {9, 10,   0, 11, Integer.MAX_VALUE,   2},
            {Integer.MAX_VALUE, 15, 11,   0,   6, Integer.MAX_VALUE},
            {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,   6,   0,   9},
            {14, Integer.MAX_VALUE,   2, Integer.MAX_VALUE,   9,   0}
        };
        
        MyGraph mg=new MyGraph();
        
        mg.setData(c);
        mg.display();
        System.out.println("bfs:");
        bfs(c,0,c.length);
        
//        System.out.println("dfs:");
//        dfs(c,0);
        
        System.out.println("dijikstra:");
        dijkstra(c,0);
    }
    
}
