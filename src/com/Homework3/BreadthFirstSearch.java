package com.Homework3;

import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {
    private int node;
    private final int numVertices;
    private final ArrayList<ArrayList<Integer>> adjacencyList;
    public BreadthFirstSearch(int startingNode, ArrayList<ArrayList<Integer>> adjacencyList, int numVertices) {
        this.node = startingNode;
        this.adjacencyList = adjacencyList;
        this.numVertices = numVertices;
    }

    public void runBFS() {
        System.out.println("\nRunning BFS on start node " + this.node + "...");
        // Set discovered[s] = true and discovered[v] = false for all other v
        boolean discovered[] = new boolean[numVertices];
        discovered[this.node]=true;
        // initialize L[0] to consist of a single element s
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(this.node);
        // Set layer counter i = 0
        int layer = 0;
        // While L[i] is not empty
        while(l.size() != 0) {
            // Initialize an empty list L[i+1]
            this.node = l.poll();
            System.out.print(this.node + " ");
            Iterator<Integer> v = this.adjacencyList.get(this.node).listIterator();
            // For each node u in L[i]
            while (v.hasNext())
            {
                // Increment the layer counter by 1
                int n = v.next();
                if (!discovered[n]) {
                    discovered[n] = true;
                    l.add(n);
                }
            }
        }
    System.out.println();
    }
}
