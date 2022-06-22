package ru.geekbrains.jads.les8;


public class HashTable {
    private LinkedList[] hashArr; // Использован список из ДЗ № 4
    private int arrSize;

    public HashTable(int size){
        this.arrSize = size;
        hashArr = new LinkedList[arrSize];
    }

    public void display() {
        for (int i = 0; i < arrSize; i++) {
            if (hashArr[i] != null) {
                System.out.println(hashArr[i]);
            } else {
                System.out.println("***");
            }
        }
    }

    private int hashFunc(int key) {
        return Math.abs(key % arrSize); // Убрал отрицательные значения (см. чуть ниже)
    }

    public void insert(Cat cat) {
        int hashVal = hashFunc(cat.hashCode()); // В имплементации ДЗ № 4 уже была такая функция
        if (hashArr[hashVal] == null) hashArr[hashVal] = new LinkedList();
        hashArr[hashVal].push(cat);
    }

    public Cat delete(Cat cat) {
        int hashVal = hashFunc(cat.hashCode());
        if (hashArr[hashVal] != null) {
            Cat deletedCat = hashArr[hashVal].delete(cat);
            if (hashArr[hashVal].isEmpty()) hashArr[hashVal] = null; // Убираю пустой список для единообразия в display(), либо можно туда добавить проверку isEmpty
            return deletedCat;
        }
        else return null;
    }

    public Cat find(Cat cat) {
        int hashVal = hashFunc(cat.hashCode());
        if (hashArr[hashVal] != null)
            return hashArr[hashVal].find(cat);
        else return null;
    }

}
