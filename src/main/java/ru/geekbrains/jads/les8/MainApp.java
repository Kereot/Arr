package ru.geekbrains.jads.les8;

public class MainApp {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.insert(new Cat("Barsik", 2));
        Cat mursik = new Cat("Mursik", 5);
        hashTable.insert(mursik);
        hashTable.insert(new Cat("Geek", 4));
        hashTable.insert(new Cat("Brains", 2));
        hashTable.insert(new Cat("Joshua", 7));
        hashTable.insert(new Cat("Cat", 1));
        hashTable.insert(new Cat("Jerome", 10));
        hashTable.insert(new Cat("Pawn", 6));
        hashTable.display();
        System.out.println();
        /*
***
***
[ Node{cat=Cat{name='Brains, age=2} ]
[ Node{cat=Cat{name='Jerome, age=10} ]
[ Node{cat=Cat{name='Joshua, age=7} ]
[ Node{cat=Cat{name='Barsik, age=2} ]
[ Node{cat=Cat{name='Cat, age=1} ]
***
***
[ Node{cat=Cat{name='Pawn, age=6}, Node{cat=Cat{name='Geek, age=4}, Node{cat=Cat{name='Mursik, age=5} ]

Process finished with exit code 0
         */
        System.out.println(hashTable.find(mursik));
        System.out.println(hashTable.find(new Cat("Cat", 1)));
        System.out.println(hashTable.find(new Cat("Nocat", 0)));
        System.out.println(hashTable.delete(mursik));
        System.out.println(hashTable.delete(new Cat("Cat", 1)));
        hashTable.insert(new Cat("Max", 16));
        System.out.println();
        hashTable.display();
        /*
***
***
[ Node{cat=Cat{name='Brains, age=2} ]
[ Node{cat=Cat{name='Max, age=16}, Node{cat=Cat{name='Jerome, age=10} ]
[ Node{cat=Cat{name='Joshua, age=7} ]
[ Node{cat=Cat{name='Barsik, age=2} ]
***
***
***
[ Node{cat=Cat{name='Pawn, age=6}, Node{cat=Cat{name='Geek, age=4} ]
         */
    }
}
