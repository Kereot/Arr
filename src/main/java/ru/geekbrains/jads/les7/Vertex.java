package ru.geekbrains.jads.les7;

public class Vertex {
    public char label;
    public boolean wasVisited;
    public Vertex previous;

    public Vertex(char label) {
        this.label = label;
        this.wasVisited = false;
        this.previous = null;
    }

    @Override
    public String toString() {
        return "{"
                + label +
                '}';
    }
}
