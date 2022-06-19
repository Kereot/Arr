package ru.geekbrains.jads.les7;

import java.util.*;

public class Graph {
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph(int vertexMax){ // из методички
        vertexList = new Vertex[vertexMax];
        adjMat = new int[vertexMax][vertexMax];
        size = 0;
        for (int i = 0; i < vertexMax; i++) {
            for (int j = 0; j < vertexMax; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label){ // из методички
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){ // из методички
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){ // из методички
        System.out.println(vertexList[vertex]);
    }

    private int getAdjUnvisitedVertex(int ver){ // из методички
        for (int i = 0; i < size; i++) {
            if (adjMat[ver][i] == 1 && !vertexList[i].wasVisited) {
                return i;
            }
        }
        return -1;
    }

    public void bfs() { // из методички
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
        displayVertex(0);
        queue.add(0);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < size; i++)
            vertexList[i].wasVisited = false;
    }

    private int getVertex(char vChar) {
        for (int i = 0; i < size; i++) {
            if (vertexList[i].label == vChar) return i;
        }
        throw new RuntimeException("This entry doesn't exist: " + vChar);
    }

    public void findRoute(char base, char dest) {
        Queue<Integer> queue = new LinkedList<>();
        int b = getVertex(base);
        vertexList[b].wasVisited = true;
        queue.add(b);
        int v2;
        while (!queue.isEmpty()) {
            int v1 = queue.remove();
            while ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
                vertexList[v2].wasVisited = true;
                vertexList[v2].previous = vertexList[v1];
                queue.add(v2);
                if (vertexList[v2].label == dest) break;
            }
        }
        Deque<Vertex> route = new LinkedList<>();
        Vertex v = vertexList[getVertex(dest)];
        while (v != null) {
            route.addFirst(v);
            v = v.previous;
        }
        System.out.println(route);
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
            vertexList[i].previous = null;
        }
    }
}
