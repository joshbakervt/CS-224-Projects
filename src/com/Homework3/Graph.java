package com.Homework3;
import java.util.*;

public class Graph {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void printAdjacencyList(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print(i);
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print("->" + adj.get(i).get(j));
            }
            System.out.println();
        }
    }

    public static ArrayList<ArrayList<Integer>> createGraph() {
        int vertexCount = 9;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>> (vertexCount);
        for(int i = 0; i < vertexCount; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 2, 4);
        addEdge(adjacencyList, 2, 5);
        addEdge(adjacencyList, 3, 5);
        addEdge(adjacencyList, 3, 7);
        addEdge(adjacencyList, 3, 8);
        addEdge(adjacencyList, 4, 5);
        addEdge(adjacencyList, 5, 6);
        addEdge(adjacencyList, 7, 8);
        return(adjacencyList);
    }
    public static void main(String[] args) {
        int vertexCount = 9;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<ArrayList<Integer>> (vertexCount);
        for(int i = 0; i < vertexCount; i++) {
            adjacencyList.add(new ArrayList<Integer>());
        }
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 2, 4);
        addEdge(adjacencyList, 2, 5);
        addEdge(adjacencyList, 3, 5);
        addEdge(adjacencyList, 3, 7);
        addEdge(adjacencyList, 3, 8);
        addEdge(adjacencyList, 4, 5);
        addEdge(adjacencyList, 5, 6);
        addEdge(adjacencyList, 7, 8);
        printAdjacencyList(adjacencyList);
    }
}