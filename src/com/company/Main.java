package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    private int V; // No of vertices
    private LinkedList<Integer> adj[]; // Adjacency Lists

    Main(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    void edges(int x, int y){
        adj[x].add(y);
    }

    void BFS(int s){
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            s = queue.poll();
            System.out.print(s+ " ");

            Iterator<Integer> i = adj[s].listIterator();

            while(i.hasNext()){
                int n = i.next();
                if(!visited[n]){
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Main g = new Main(4);
        g.edges(0, 1);
        g.edges(0, 2);
        g.edges(1, 2);
        g.edges(2, 0);
        g.edges(2, 3);
        g.edges(3, 3);

        System.out.println("Following is Breadth First Traversal (starting from vertex 2");

        g.BFS(2);
    }
}
