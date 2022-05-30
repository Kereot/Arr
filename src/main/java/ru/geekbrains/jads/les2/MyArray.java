package ru.geekbrains.jads.les2;

import java.util.*;

public class MyArray {
    private int[] arr;
    private int capacity;

//    //new int[5];
//    public MyArray(int size) {
//        this.capacity = 0;
//        this.arr = new int[size];
//    }

    // = {1,2,3,4,5};
    public MyArray(int[] init) { // с урока
        this.capacity = init.length;
        this.arr = init;
    }

    void display() { // с урока
        for (int i = 0; i < this.capacity; ++i) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

//    public int get(int idx) {
//        return arr[idx];
//    }
//
//    public void set(int value, int idx) {
//        arr[idx] = value;
//    }
//
//    boolean delete(int value) {
//        for (int i = 0; i < this.capacity; i++) {
//            if (this.arr[i] == value) {
//                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
//                --capacity;
//                return true;
//            }
//        }
//        return false;
//    }

//    boolean deleteAllFirstIdea(int value) { // ЗАДАНИЕ 1, первая имплементация
//        int[] temp = new int[capacity];
//        int mark = 0;
//        for (int i = 0; i < capacity; i++) {
//            if (arr[i] != value) {
//                temp[mark] = arr[i];
//                mark++;
//            }
//        }
//        if (mark == capacity) {
//            return false;
//        }
//        System.arraycopy(temp, 0, arr, 0, mark);
////        arr = Arrays.copyOf(temp, mark);
//        capacity = mark;
//        return true;
//    }

    boolean deleteAll(int value) { // ЗАДАНИЕ 1
        int mark = 0;
        for (int i = 0; i < capacity; i++) {
            if (arr[i] != value) {
                arr[mark] = arr[i];
                mark++;
            }
        }
        if (mark == capacity) {
            return false;
        }
        System.arraycopy(arr, 0, arr, 0, mark); // это оставит хвост (который не будет показан, когда изменим capacity)
//        arr = Arrays.copyOf(arr, mark); // без хвоста
        capacity = mark;
        return true;
    }

    boolean deleteAll() { // ЗАДАНИЕ_2
//        for (int i = 0; i < arr.length; i++) { // arr.length чтобы удалить вообще всё
//            this.arr[i] = 0;
//        }
        Arrays.fill(arr, 0);
        capacity = arr.length; // или capacity = 0 ... какая задача?
        return true;
    }

    void insert(int idx, int value) { // ЗАДАНИЕ_3
        if (idx > capacity) {
            for (int i = capacity; i < idx; i++) {
                if (i == idx - 1) {
                    append(value);
                } else {
                    append(0);
                }
            }
            return;
        }
        int[] temp = new int[capacity + 1 - idx];
        temp[0] = value;
//        for (int i = 1; i < capacity + 1 - idx; i++) {
//            temp[i] = arr[idx + i - 1];
//        }
        if (capacity - idx >= 0) // Это Идея подсказала по вышеуказанному варианту
            System.arraycopy(arr, idx, temp, 1, capacity - idx);
        if (capacity == arr.length) {
            int[] old = arr;
            arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, idx);
        }
        System.arraycopy(temp, 0, arr, idx, temp.length);
        capacity += 1;
    }

    void append(int value) { // с урока
        if (this.capacity == this.arr.length) {
            int[] old = this.arr;
            this.arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, old.length);
        }
        this.arr[this.capacity++] = value;
    }

//    public boolean isInArray(int value) { // O(n)
//        for (int i = 0; i < this.capacity; i++)
//            if (this.arr[i] == value)
//                return true;
//        return false;
//    }

    //O(log(N))
//    public boolean hasValue(int value) {
//        int low = 0;
//        int high = this.capacity - 1;
//        int mid;
//        while (low < high) {
//            mid = (low + high) / 2;
//            if (value == this.arr[mid]) {
//                return true;
//            } else {
//                if (value < this.arr[mid]) {
//                    high = mid;
//                } else {
//                    low = mid + 1;
//                }
//            }
//        }
//        return false;
//    }

    private boolean swap(int a, int b) { // с урока*
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
        return true;
    }

    public void sortBubble() { // с урока
        for (int iter = 0; iter < capacity; iter++)
            for (int idx = 0; idx < capacity - 1; idx++)
                if (this.arr[idx] > this.arr[idx + 1])
                    swap(idx, idx + 1);
    }

    public void sortBubbleMinorTweaks() { // ЗАДАНИЕ_4
        boolean didSwap;
        for (int iter = 0; iter < capacity - 1; iter++) {
            didSwap = false;
            for (int idx = 0; idx < capacity - 1 - iter; idx++){
                if (this.arr[idx] > this.arr[idx + 1]) {
                    didSwap = swap(idx, idx + 1);
                    // *Ну, это я так. Метод swap изначально был void, так что здесь нужно было просто новой строкой задать didSwap = true;
                    // но у нас столько boolean методов, а return нигде не используем :)
                }
            }
            if (!didSwap) break;
        }
        // К вопросу о "погуглить": в методичке можно пройти по соотв. ссылке из раздела дополнительных материалов,
        // там описана "шейкер-сортировка", такой вот спойлер :)
        // Я такой вариант и не обдумывал, конечно, но просто копи-пастить как-то не интересно, так что не стал переносить.
    }

//    public void sortSelect() {
//        for (int idx = 0; idx < capacity; idx++) {
//            int curr = idx;
//            for (int srch = idx + 1; srch < capacity; srch++)
//                if (this.arr[srch] < this.arr[curr])
//                    curr = srch;
//            if (curr != idx)
//                swap(idx, curr);
//        }
//    }
//
//    public void sortInsert() {
//        for (int curr = 1; curr < capacity; curr++) {
//            int temp = this.arr[curr];
//            int move = curr;
//            while (move > 0 && this.arr[move - 1] >= temp) {
//                this.arr[move] = this.arr[move - 1];
//                move--;
//            }
//            this.arr[move] = temp;
//        }
//    }

    public void sortCountNotWhatNeeded() { // Эксперимент; вариант чисто на массивах в методе ниже.
        // Я понимаю, что это не то, что требовалось, но было интересно.
        // Плюс это оказалось полезным для проверки основного метода.
        // Не осилил подсчитать сложность - надо копаться внутри этих готовых методов,
        // но подозреваю, что О просто лопается от неё :)
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < capacity; i++) {
            map.merge(arr[i], 1, Integer::sum);
//            if (!map.containsKey(arr[i])) {
//                map.put(arr[i], 1);
//            } else {
//                int a = map.get(arr[i]);
//                a += 1;
//                map.put(arr[i], a);
//            }
        }
        System.out.println(map);
        Set<Map.Entry<Integer, Integer> > entrySet = map.entrySet();
        arr = new int[capacity];
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            for (int i = 0; i < entry.getValue(); i++) {
                arr[count] = entry.getKey();
                count += 1;
            }
        }
    }

    public void sortCount() { // ЗАДАНИЕ_5
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < capacity - 1; i++) {
            if (min > arr[i + 1]) { // При отрицательных числах, min и max поменяются местами
                min = arr[i + 1];
            }
            if (max < arr[i + 1]) {
                max = arr[i + 1];
            }
        }
        int[] count;
            count = new int[max - min + 1];
            for (int i = 0; i < capacity; i++) {
                if (count[arr[i] - min] == 0) {
                    count[arr[i] - min] = 1;
                } else {
                    int a = count[arr[i] - min];
                    count[arr[i] - min] = a + 1;
                }
            }
            System.out.println(Arrays.toString(count));
        int mark = 0;
        arr = new int[capacity];
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                for (int j = 0; j < count[i]; j++) {
                    arr[mark] = i + min;
                    mark++;
                }
            }
        }
    }
}
