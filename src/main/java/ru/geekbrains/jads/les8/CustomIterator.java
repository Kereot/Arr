package ru.geekbrains.jads.les8;

import lombok.Getter;

public class CustomIterator { // Из ДЗ №4
    @Getter
    private Node first;
    @Getter // to test
    private LinkedList list;

    public CustomIterator(LinkedList list) {
        this.list = list;
        reset();
    }

    public void reset() {
        first = list.getFirst();
    }

    public void nextLink() {
        if (first.getNext() != null) first = first.getNext();
        else reset();
    }

    public Cat getCurrent() {
        if (first == null) return null;
        return first.getCat();
    }

    public boolean atEnd() {
        return first.getNext() == null;
    }

    public void insertAfter(Cat cat) {
        if (cat == null) return;
        Node newNode = new Node(cat);
        if (!list.isEmpty()) {
            if (!atEnd()) {
                newNode.setNext(first.getNext());
                first.getNext().setPrevious(newNode);
            } else list.setLast(newNode);
            first.setNext(newNode);
            newNode.setPrevious(first);
        } else {
            list.setFirst(newNode);
            list.setLast(newNode);
            first = newNode;
        }
        list.setSize(list.getSize() + 1);
    }

    public void insertBefore(Cat cat) {
        if (cat == null) return;
        Node newNode = new Node(cat);
        if (!list.isEmpty()) {
            if (first.getPrevious() != null) {
                newNode.setPrevious(first.getPrevious());
                first.getPrevious().setNext(newNode);
            } else list.setFirst(newNode);
            first.setPrevious(newNode);
            newNode.setNext(first);
        } else {
            list.setFirst(newNode);
            list.setLast(newNode);
            first = newNode;
        }
        list.setSize(list.getSize() + 1);
    }

    public Cat deleteCurrent() {
        if (first == null) return null;
        Cat cat = first.getCat();
        if (first.getPrevious() == null && !atEnd()) {
            list.setFirst(null);
            list.setLast(null);
            reset();
        } else if (first.getPrevious() == null) {
            list.setFirst(first.getNext());
            list.getFirst().setPrevious(null);
            reset();
        } else if (atEnd()) {
            list.setLast(first.getPrevious());
            list.getLast().setNext(null);
            first = first.getPrevious();
        } else {
            first.getPrevious().setNext(first.getNext());
            first.getNext().setPrevious(first.getPrevious());
            first = first.getNext();
        }
        list.setSize(list.getSize() - 1);
        return cat;
    }


    private Node getNode(int idx) {
        if (list.isEmpty()) return null;
        Node mark = list.getFirst();
        for (int i = 0; i <= idx; i++) {
            if (i == idx) {
                return mark;
            }
            if (mark.getNext() == null) return null;
            mark = mark.getNext();
        }
        return null;
    }

    public Cat getMyCat(int idx) {
        if (idx < 0 || idx > (list.getSize() - 1))
            throw new IndexOutOfBoundsException("There's no such cat basket");
        if (getNode(idx) == null) throw new NullPointerException("There's no cat in this basket");
        else return getNode(idx).getCat();
    }
}