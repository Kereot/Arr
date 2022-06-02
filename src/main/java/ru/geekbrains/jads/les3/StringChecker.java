package ru.geekbrains.jads.les3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringChecker {
// Just some fun...
//    private static final Pattern P1 = Pattern.compile("[^\\[{(]");
//    private static final Pattern P2 = Pattern.compile("[^\\]})]");
//
//    public static boolean checkString(String s) {
//        Matcher m1 = P1.matcher(s);
//        Matcher m2 = P2.matcher(s);
//        int c1 = 0;
//        int c2 = 0;
//        while (m1.find()) {
//            c1 += m1.group().length();
//        }
//        while (m2.find()) {
//            c2 += m2.group().length();
//        }
//        return c1 == c2;
//    }

    // В общем то в методичке всё расписано, что-то лучше придумать мне не удалось.
    // Была мысль складывать каждый тип в свой массив, но зачем...
    // Ну вот добавил проверку на вложенную строку и на начало коммента,
    // и на сам char. Но к самому стеку это не имеет отношения.
    private class Stack {
        private int maxSize;
        private char[] stack;
        private int head;

        public Stack(int size) {
            maxSize = size;
            stack = new char[maxSize];
            head = -1;
        }

        public boolean isEmpty() { return head == -1; }

        public void push(char i) {
            stack[++head] = i;
        }

        public char pop() {
            return stack[head--];
        }
    }

    private String string;

    public StringChecker(String s) {
        string = s;
    }

    public void checkString() {
        int length = string.length();
        Stack stack = new Stack(length);
        int comment = 0;
        boolean innerText = false;
        int charCheckCount = 0;
        boolean charCheckState = false;
        for (int i = 0; i < length; i++) {
            char ch = string.charAt(i);
            if (innerText) {
                if (ch == '"') {
                    innerText = false;
                }
                continue;
            }
            if (charCheckState) {
                if (charCheckCount < 2) {
                    charCheckCount++;
                } else break;
            }
            if (ch == '/') {
                comment++;
                if (comment == 2) {
                    break;
                }
            } else {
                comment = 0;
            }
            if (ch == '"') {
                innerText = true;
            }
            if (ch == 39) {
                if (!charCheckState) {
                    charCheckState = true;
                } else {
                    charCheckState = false;
                    charCheckCount = 0;
                }

            }
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            }
            if (ch == ']' || ch == '}' || ch == ')') {
                if (!stack.isEmpty()) {
                    char chk = stack.pop();
                    if ((ch == '}' && chk != '{') || (ch == ']' && chk !='[') || (ch == ')' && chk != '(')) {
                        System.out.println("Error: " + ch + " at " + i);
                    }
                } else {
                    System.out.println("Error: " + ch + " at " + i);
                }
            }
        }
        if (innerText) {
            System.out.println("Error: string not closed");
        }
        if (charCheckState) {
            System.out.println("Error: char usage");
        }
        if (!stack.isEmpty()) {
            System.out.println("Error: missing right delimiter");
        }
    }
}
