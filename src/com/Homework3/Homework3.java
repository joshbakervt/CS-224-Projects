package com.Homework3;
import java.util.ArrayList;
import java.util.Scanner;

public class Homework3 {

    public static int getStartingNode() {
        // Prompt user for either BFS or DFS
        Scanner startChoice = new Scanner(System.in);
        int nodeChoice;
        do {
            System.out.print("\nEnter a start node value 1 through 8: ");
            nodeChoice = startChoice.nextInt();
        } while (nodeChoice < 1 || nodeChoice > 8);
        System.out.println("\n" + nodeChoice + " selected");
        return nodeChoice;
    }

    public static void main(String[] args) {
        int startNode;
        int numVertices = 9;
        ArrayList<ArrayList<Integer>> adjacencyList = Graph.createGraph();
        // Prompt user for either BFS or DFS
        do {
            Scanner searchChoice = new Scanner(System.in);
            int algoChoice;
            do {
                System.out.print("\nEnter either 1 to run breadth-first search or 2 to run depth-first search: ");
                algoChoice = searchChoice.nextInt();
            } while (algoChoice != 1 && algoChoice != 2);
            if (algoChoice == 1) {
                System.out.println("\nBFS selected");
                startNode = getStartingNode();
                BreadthFirstSearch bfs = new BreadthFirstSearch(startNode, adjacencyList, numVertices);
                bfs.runBFS();
            } else {
                System.out.println("\nDFS selected");
                startNode = getStartingNode();
                DepthFirstSearch dfs = new DepthFirstSearch(startNode, adjacencyList, numVertices);
                dfs.runDFS();
            }
        } while(true);
    }
}
