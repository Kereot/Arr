package ru.geekbrains.jads.les3;

public class PriorityQueue {
    private int maxSize; // размер
    private int[] pQueue; // храним значения
    private int[] pWeight; // храним приоритеты (ниже - важнее)
    // В методичке уже есть вариант, так что я решил придумать что-то другое и более универсальное.
    private int items;   // текущее количество

    public PriorityQueue(int s) {
        maxSize = s;
        pQueue = new int[maxSize];
        pWeight = new int[maxSize];
        items = 0;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public void insert(int value, int weight) {
        if (isFull()) {
            // Простое увеличение, т.к. элементы добавляются в разные места;
            // по поводу кода увеличения, как на уроке: он у меня не сработал (см. ниже).
            doubleSize();
        }
        if (isEmpty()) { // Добавим первое значение без проверок.
            pWeight[0] = weight;
            pQueue[0] = value;
        } else {
            for (int i = 0; i < items; i++) {
                if (weight >= pWeight[i]) {
                    // Ищем, есть ли более приоритетные значения, и встаём за ним.
                    // При равенстве предпочтение отдаём тому, что пришло первым.
                    // Индексы двух массивов всегда взаимосвязаны.
                    int[] tempW = pWeight;
                    int[] tempQ = pQueue;
                    System.arraycopy(tempW, i, pWeight, i + 1, items - i);
                    System.arraycopy(tempQ, i, pQueue, i + 1, items - i);
                    pWeight[i] = weight;
                    pQueue[i] = value;
                    break;
                } else if (i == items - 1) { // Если не нашли, то это значение становится в начало очереди.
                    pWeight[items] = weight;
                    pQueue[items] = value;
                }
            }
        }
        items++;
    }

// Я изначально пытался здесь сделать увеличение, как на уроке с очередью.
// Потом пришёл к выводу (возможно и неверному), что оно здесь не нужно. Тем не менее:
// Я потестировал код с урока (конечно, добавил пропущенное обновление ссылки).
// В определённых ситуациях результат был кривым. Какая-то проблема с head.
// При увеличении массива с последующим удалением элемента, head уходит на какие-то странные значения.
// Скорее всего проблема в head = maxSize - head - 1.
// Проявляется только в некоторых сочетаниях изначального размера и количества удалений
// (или наоборот - в некоторых всё сходится).
// ToDo: Upd: вот это вариант может работать, как надо: head = maxSize - head + tail
// ToDo: Кроме того, коллега Александр Свешников предложил head = maxSize - (queue.length - head)
// ToDo: Мы проверили на нескольких раскладах по коду с урока - оба эти варианты работают,
// ToDo: однако, я не могу гарантировать, что это не просто удачное совпадение.
// Как и писал выше, здесь не вижу в этом необходимости.

    private void doubleSize() {
        maxSize *= 2;
        int[] tmpQ = new int[maxSize];
        int[] tmpW = new int[maxSize];
        System.arraycopy(pQueue, 0, tmpQ, 0, pQueue.length);
        System.arraycopy(pWeight, 0, tmpW, 0, pWeight.length);
        pQueue = tmpQ;
        pWeight = tmpW;
    }

    public int remove() {
        if (isEmpty()) throw new RuntimeException("Array is empty!");
        return pQueue[--items];
    }

    public int peek() {
        return pQueue[items - 1];
    }
}
