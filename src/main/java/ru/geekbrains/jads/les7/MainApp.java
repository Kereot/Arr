package ru.geekbrains.jads.les7;

public class MainApp {
    public static void main(String[] args) {
        Graph graph = new Graph(11); // Граф с урока
        graph.addVertex('A'); // 0
        graph.addVertex('B'); // 1
        graph.addVertex('C'); // 2
        graph.addVertex('D'); // 3
        graph.addVertex('E'); // 4
        graph.addVertex('F'); // 5
        graph.addVertex('G'); // 6
        graph.addVertex('H'); // 7
        graph.addVertex('I'); // 8
        graph.addVertex('J'); // 9
        graph.addVertex('K'); // 10
        graph.addEdge(0, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 9);
        graph.addEdge(9, 10);
        graph.addEdge(10, 8);
        graph.addEdge(8, 4);
        graph.addEdge(4, 3);
        graph.addEdge(3, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 6);
        graph.addEdge(6, 7);
        graph.addEdge(6, 9);

//        graph.bfs();

        graph.findRoute('A', 'K');
        graph.findRoute('F', 'E');
        graph.findRoute('H', 'B');
        graph.findRoute('A', 'A');
        graph.findRoute('I', 'H');
//        graph.findRoute('A', 'Z');
    }
}
