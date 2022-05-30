package ru.geekbrains.jads.les2;

public class Main {
    public static void main(String[] args) {

        MyArray arr0 = new MyArray(new int[]{2, 2, 5, 6, 8, 2, 3, 5, 11, 0, 6, 11});
        arr0.deleteAll(2);
        arr0.deleteAll(11);
        arr0.display();
        arr0.deleteAll();
        arr0.display();
        MyArray arr = new MyArray(new int[]{2, 2, 5, 6, 8, 2, 3, 5, 11, 0, 6, 11});
        arr.insert(2, 15);
        arr.insert(13 , 30);
        arr.insert(18, -45);
        arr.insert(16, 60);
        arr.insert(2, 75);
        arr.display();
        arr.sortBubble();
        arr.display();
        arr.sortBubbleMinorTweaks();
        arr.display();

        MyArray arr1 = new MyArray(new int[]{2, 2, 5, 6, 8, 2, 3, 5, 11, 0, 6});
        arr1.sortBubble();
        arr1.display();
        arr1.sortBubbleMinorTweaks();
        arr1.display();

        MyArray arr20 = new MyArray(new int[]{2, 2, 5, 6, 8, 2, 3, 5, 11, 0, 6});
        arr20.sortCountNotWhatNeeded();
        arr20.display();
        arr20.sortCount();
        arr20.display();

        MyArray arr201 = new MyArray(new int[]{5, 6, 8, 3, 18, 21, 21, 3, 9, 5, 11, 6});
        arr201.sortCountNotWhatNeeded();
        arr201.display();
        arr201.sortCount();
        arr201.display();

        MyArray arr202 = new MyArray(new int[]{5, 6, 8, 6});
        arr202.sortCountNotWhatNeeded();
        arr202.display();
        arr202.sortCount();
        arr202.display();

        MyArray arr203 = new MyArray(new int[]{2042, 2059, 2041, 2045, 2059, 2042, 2041, 2050});
        arr203.sortCountNotWhatNeeded();
        arr203.display();
        arr203.sortCount();
        arr203.display();

        MyArray arr21 = new MyArray(new int[]{2, -2, -5, 6, 8, 2, 3, -5, 6});
        arr21.sortCountNotWhatNeeded();
        arr21.display();
        arr21.sortCount();
        arr21.display();

        MyArray arr22 = new MyArray(new int[]{-2, -2, -5, -6, -11, 0, -6});
        arr22.sortCountNotWhatNeeded();
        arr22.display();
        arr22.sortCount();
        arr22.display();

        MyArray arr221 = new MyArray(new int[]{-2, -2, -5, -6, -11, -6});
        arr221.sortCountNotWhatNeeded();
        arr221.display();
        arr221.sortCount();
        arr221.display();


    }
}
