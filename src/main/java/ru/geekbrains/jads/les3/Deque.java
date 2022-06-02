package ru.geekbrains.jads.les3;

public class Deque {
    private int maxSize; // размер
    private int[] deque; // место хранения
    private int items;   // текущее количество

    public Deque(int s) {
        maxSize = s;
        deque = new int[maxSize];
        items = 0;
    }

    public void display() {
        for (int i = 0; i < items; ++i) {
            System.out.print(deque[i] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty() { return (items == 0); }
    public boolean isFull() { return (items == maxSize); }
    public int size() { return items; }

    public void insertLeft(int i) {
        // Moves all elements of the array one step left and writes the value as the 1st(0) element
        if (isFull()) {
            deque = doubleSize();
        }
        int[] temp = deque;
        System.arraycopy(temp, 0, deque, 1, items);
        deque[0] = i;
        items++;
    }

    public void insertRight(int i) {
        // Writes the value as the last element of the array,
        // shouldn't rewrite sensitive data as it expands the array when needed
        if (isFull()) {
            deque = doubleSize();
        }
        deque[items++] = i;
    }

    private int[] doubleSize() {
        maxSize *= 2;
        int[] temp = new int[maxSize];
        System.arraycopy(deque, 0, temp, 0, deque.length);
        return temp;
    }

    public int removeRight() {
        if (isEmpty()) throw new RuntimeException("Array is empty!");
        int temp = deque[items - 1];
        items--;
        return temp;
    }

    public int removeLeft() {
        if (isEmpty()) throw new RuntimeException("Array is empty!");
        int tempItem = deque[0];
        int[] temp = new int[maxSize];
        System.arraycopy(deque, 1, temp, 0, deque.length - 1);
        deque = temp;
        items--;
        return tempItem;
    }

    public int peekRight(){
        if (isEmpty()) throw new RuntimeException("Array is empty!");
        return deque[items - 1];
    }

    public int peekLeft(){
        if (isEmpty()) throw new RuntimeException("Array is empty!");
        return deque[0];
    }
}
