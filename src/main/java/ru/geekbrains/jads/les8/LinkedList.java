package ru.geekbrains.jads.les8;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LinkedList { // Из ДЗ №4
    private Node first;
    private Node last;
    private int size;
    private CustomIterator iterator;

    public LinkedList() {
        first = null;
        last = null;
        iterator = new CustomIterator(this);
        size = 0;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private void resetIterator() {
        if (iterator != null) {
            iterator.reset();
        }
    }

    public void push(Cat cat) {
        if (cat == null) return;
        Node newNode = new Node(cat);
        newNode.setNext(first);
        if (isEmpty()) last = newNode;
        else first.setPrevious(newNode);
        first = newNode;
        resetIterator();
        size++;
    }

    public void pushLast(Cat cat) {
        if (cat == null) return;
        Node newNode = new Node(cat);
        newNode.setPrevious(last);
        if (isEmpty()) first = newNode;
        else last.setNext(newNode);
        last = newNode;
        resetIterator();
        size++;
    }

    public Cat popFirst() {
        if (isEmpty()) return null;
        Cat cat = first.getCat();
        if (first.getNext() == null) last = null;
        first = first.getNext();
        first.setPrevious(null);
        resetIterator();
        size--;
        return cat;
    }

    public Cat popLast() { // Queue
        if (isEmpty()) return null;
        Cat cat = last.getCat();
        last = last.getPrevious();
        if (last != null) last.setNext(null);
        resetIterator();
        size--;
        return cat;
    }

    public Cat peek() {
        if (isEmpty()) return null;
        return first.getCat();
    }

    public Cat peekLast() {
        if (isEmpty()) return null;
        return last.getCat();
    }

    public void display() {
        Node current = first;
        System.out.println();
        while (current != null) {
            System.out.println(current.getCat());
            current = current.getNext();
        }
        System.out.println();
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("[ ");
        while (current != null) {
            sb.append(current);
            current = current.getNext();
            sb.append((current == null) ? " ]" : ", ");
        }
        return sb.toString();
    }

    public Cat find(Cat cat) {
        Node curr = first;
        while (!curr.getCat().equals(cat)) {
            if (curr.getNext() == null) {
                return null;
            } else {
                curr = curr.getNext();
            }
        }
        return curr.getCat();
    }

    public Cat delete(Cat cat) {
        if (cat == null) return null;
        Node curr = first;
        Node prev = first;
        while (!curr.getCat().equals(cat)) {
            if (curr.getNext() == null) return null;
            else {
                prev = curr;
                curr = curr.getNext();
            }
        }
        if (curr == first && curr == last) {
            first = null;
            last = null;
        }
        else if (curr == first) {
            first = first.getNext();
            first.setPrevious(null);
        } else if (curr == last) {
            last = last.getPrevious();
            last.setNext(null);
        } else {
            curr.getPrevious().setNext(curr.getNext());
            curr.getNext().setPrevious(prev);
        }
        resetIterator();
        size--;
        return curr.getCat();
    }


}