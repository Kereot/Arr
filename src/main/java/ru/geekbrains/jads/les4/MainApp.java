package ru.geekbrains.jads.les4;

public class MainApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        CustomIterator iterator = list.getIterator();
        list.push(new Cat("FirstList", 1));
        iterator.insertAfter(new Cat("FirstIterator", 11));
        System.out.println(iterator.getCurrent());
        System.out.println(list);
        System.out.println("Check: FL - FI");
        System.out.println(list.delete(new Cat("FirstIterator", 11)));
        list.pushLast(new Cat("SecondList", 2));
        System.out.println(list);
        System.out.println("Check: FL - SL");
        System.out.println(iterator.getCurrent());
        iterator.insertBefore(new Cat("SecondIterator",12));
        System.out.println(iterator.getCurrent());
        System.out.println(list);
        System.out.println("Check: SI - FL - SL");
        iterator.nextLink();
        System.out.println(iterator.getCurrent());
        System.out.println(iterator.deleteCurrent());
        System.out.println(list);
        System.out.println("Check: SI - FL");
        System.out.println(list.peekLast());
        System.out.println(iterator.atEnd());
        System.out.println(iterator.getList().isEmpty());
        iterator.insertAfter(new Cat("ThirdIterator",13));
        System.out.println(list);
        System.out.println("Check: SI - FL - TI");
        list.display();
        System.out.println(iterator.getMyCat(0));
        CustomIterator iterator1 = new CustomIterator(list);
        System.out.println(iterator1.getMyCat(2));
        System.out.println(list.popLast());
        System.out.println(list.popFirst());
        System.out.println(list);
        System.out.println("Check: FL");
    }
}
