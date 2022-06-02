package ru.geekbrains.jads.les3;

public class MainApp {
    public static void main(String[] args) {
        Deque arr = new Deque(5);

        arr.insertLeft(2);
        arr.insertRight(4);
        arr.insertLeft(2);
        arr.insertRight(5);
        arr.display();
        arr.removeLeft();
        arr.removeRight();
        arr.display();
        arr.insertLeft(11);
        arr.insertLeft(12);
        arr.insertRight(251);
        arr.insertRight(252);
        arr.insertLeft(13);
        arr.insertLeft(14);
        arr.insertRight(253);
        arr.insertLeft(15);
        arr.display();
        arr.removeLeft();
        arr.removeRight();
        arr.removeLeft();
        arr.display();
        System.out.println();

        PriorityQueue pQueue = new PriorityQueue(3);

        pQueue.insert(3, 5);
        pQueue.insert(12, 2);
        System.out.println(pQueue.remove());
        pQueue.insert(90, 90);
        pQueue.insert(3, 1);
        pQueue.insert(2, 3);
        pQueue.insert(4, 1);
        pQueue.insert(10, 2);
        pQueue.insert(42, -1);
        System.out.println(pQueue.remove());
        System.out.println(pQueue.remove());
        System.out.println(pQueue.remove());
        System.out.println();

        StringChecker s = new StringChecker("Hello, (World), {yes?}");
        StringChecker s1 = new StringChecker("Hello, (World), yes?}");
        StringChecker s2 = new StringChecker("Hello, (World, {yes?}");
        StringChecker s3 = new StringChecker("Hello, (World//), {yes?}");
        StringChecker s4 = new StringChecker("Hello, (World), //yes?}");
        StringChecker s5 = new StringChecker("Hello, (World), '{'yes?}");
        StringChecker s6 = new StringChecker("Hello, (World'), {'yes?}");
        StringChecker s7 = new StringChecker("Hello, (World), {''yes?}");
        StringChecker s8 = new StringChecker("Hello, (World'), {yes?}");
        s.checkString(); // nothing
        System.out.println();
        s1.checkString(); // error @
        s2.checkString(); // error delimiter
        s3.checkString(); // error delimiter
        s4.checkString(); // nothing
        System.out.println();
        s5.checkString(); // nothing
        System.out.println();
        s6.checkString(); // error char
        s7.checkString(); // nothing
        System.out.println();
        s8.checkString(); // error char
        //can't check "" with that, but should be ok
    }
}
