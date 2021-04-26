package com.company;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    /* number of vertices */
    private int V;

    /*
    * Adjacency Lists
    * */
    private LinkedList<Integer> adj[]; //

    /*
    * Constructor
    * param v <- ( int )
    * */
    Main(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList<>();
        }
    }

    /*
    * Add Edges to, from
    * x <- ( int )
    * y <- ( int )
    * */
    void edges(int x, int y){
        adj[x].add(y);
    }

    /**
     * Algorithm BFS ( Breadth First Search )
     * s <- ( int )
     * */
    void BFS(int s){
        // Mark all the vertices as not visited(By default set as false)
        boolean visited[] = new boolean[V];

        //Create a queue for BFS

        LinkedList<Integer> queue = new LinkedList<Integer>();

        //Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while(queue.size() != 0){
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+ " ");

            /**
             * Get all adjacent vertices of the dequeued vertex "s"
             * If a adjacent has not been visited, then mark it
             * visited and enqueue it.
             * */
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
