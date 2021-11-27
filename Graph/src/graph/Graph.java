/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import java.util.*;

class Graph {
	
    public static void addEdge(ArrayList<ArrayList<Integer> > adj,int u, int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void printGraph(ArrayList<ArrayList<Integer> > adj){
        for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of vertex" + i);
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                    System.out.print(" -> "+adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static void BFS(ArrayList<ArrayList<Integer> > adj){
        Queue<Integer> q=new LinkedList<>();
        int check[]= new int[10000];
//        for(int i=0;i<=10;i++)check[i]=0;
        q.add(0);
        check[0]=1;
        System.out.println("BFS from 0:");
        while(!q.isEmpty()){
            int x=q.poll();
            System.out.print(x+" ");
            for(int i=0;i<adj.get(x).size();i++){
                if(check[adj.get(x).get(i)]==0){
                    q.add(adj.get(x).get(i));
                    check[adj.get(x).get(i)]=1;
                }
            }
        }
        System.out.println("");
    }
    
    public static void DFSUtil(int v, int visited[],ArrayList<ArrayList<Integer> > adj){
        visited[v] = 1;
        System.out.print(v + " ");

        for(int i=0;i<adj.get(v).size();i++){
            if(visited[adj.get(v).get(i)]==0){
                DFSUtil(adj.get(v).get(i),visited,adj);
            }
        }
    }

    public static void DFS(int v,ArrayList<ArrayList<Integer> > adj){
        int visited[] = new int[1000000];
        DFSUtil(v, visited,adj);
    }
    
    public static void main(String[] args){
        // Creating a graph with 5 vertices
        int V = 5;
        ArrayList<ArrayList<Integer> > adj= new ArrayList<ArrayList<Integer> >(V);

        for (int i = 0; i < V; i++)
                adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 4);
        addEdge(adj, 1, 2);
        addEdge(adj, 1, 3);
        addEdge(adj, 1, 4);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);

        printGraph(adj);
        BFS(adj);
        DFS(0,adj);
    }
}

