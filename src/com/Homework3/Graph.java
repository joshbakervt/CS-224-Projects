package com.Homework3;
import java.util.LinkedList;

public class Graph {
    int vertex;
    LinkedList<Integer> list[];

    public Graph(int vertex) {
        this.vertex = vertex;
        list = new LinkedList[vertex];
        for (int i = 0; i < vertex; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest) {
        list[source].addFirst(dest);
        list[dest].addFirst(source);
    }

    public void printGraph(){
        for (int i = 0; i <vertex ; i++) {
            if(list[i].size()>0) {
                System.out.print("Vertex " + i + " is connected to: ");
                for (int j = 0; j < list[i].size(); j++) {
                    System.out.print(list[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(1,2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 5);
        graph.addEdge(3, 7);
        graph.addEdge(3, 8);
        graph.addEdge(4, 2);
        graph.addEdge(4, 5);
        graph.addEdge(5, 2);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 5);
        graph.addEdge(7, 3);
        graph.addEdge(7, 8);
        graph.addEdge(8, 3);
        graph.addEdge(8, 7);
        graph.printGraph();
    }
}
