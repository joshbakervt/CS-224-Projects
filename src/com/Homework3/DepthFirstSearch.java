package com.Homework3;

import java.util.*;
import java.util.ArrayList;

public class DepthFirstSearch {
    private int node;
    private final int numVertices;
    private final ArrayList<ArrayList<Integer>> adjacencyList;
    public DepthFirstSearch(int startingNode, ArrayList<ArrayList<Integer>> adjacencyList, int numVertices) {
        this.node = startingNode;
        this.adjacencyList = adjacencyList;
        this.numVertices = numVertices;
    }

    public void runDFS() {
        System.out.println("\nRunning DFS from start node " + this.node + "...");
        boolean discovered[] = new boolean[this.numVertices];
        recursiveDFS(this.node, discovered);
        System.out.println();
    }

    public void recursiveDFS(int u, boolean discovered[]) {
        // Mark u as explored
        discovered[u] = true;
        System.out.print(u + " ");
        // For each edge (u, v) incident to u
        Iterator<Integer> v = this.adjacencyList.get(u).listIterator();
        while(v.hasNext()) {
            int n = v.next();
            // If v is not marked explored
            if (!discovered[n]) {
                // Recursively invoke DFS(v)
                recursiveDFS(n, discovered);
            }
        }
    }
}
