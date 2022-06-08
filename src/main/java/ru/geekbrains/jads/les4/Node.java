package ru.geekbrains.jads.les4;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Node {
    private Cat cat;
    private Node next;
    private Node previous;

    public Node(Cat cat){
        this.cat = cat;
    }

    @Override
    public String toString() {
        return "Node{" +  "cat=" + cat;
    }
}