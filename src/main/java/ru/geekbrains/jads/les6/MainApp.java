package ru.geekbrains.jads.les6;

import java.util.HashMap;

public class MainApp {
    static HashMap<Integer, Tree> map = new HashMap<>();
    // Вынес сюда для предварительных тестов (дисплея). Так это, конечно, может остаться в методе.
    // Вместо Мапы можно использовать массив (обращение по индексу, размер - testedTrees),
    // основная реализация не поменяется.
    static float unBalancedHard = 0f;
    static float unBalancedSoft = 0f;

    public static void main(String[] args) {
        int testedTrees = 200;
        generate(200, 100);

//        map.get(1).displayTree();
//        System.out.println();

        System.out.println(unBalancedHard * 100 / (float) testedTrees);
        // HardBalance с таким кол-вом элементов (100 treeElements в generate)
        // почти никогда не случится. Заметить можно на ~20 или меньше элементах.
        System.out.println(unBalancedHard);
        System.out.println(unBalancedSoft * 100 / (float) testedTrees);
        System.out.println(unBalancedSoft);
    }

    public static void generate(int testedTrees, int treeElements) {
        int e = 1;
        while (e <= testedTrees) {
            map.put(e, new Tree());
            int i = 0;
            while (i < treeElements) {
                int v = (int) (Math.random() * 200) - 100;
                map.get(e).insert(v);
                i++;
            }
            if (!checkHardBalance(map.get(e).getRoot())) unBalancedHard++;
            if (!checkSoftBalance(map.get(e).getRoot())) unBalancedSoft++;
            e++;
        }
    }
    private static boolean checkHardBalance(Tree.TreeNode node) {
        if (node == null) return true;
        int leftCheck = depth(node.leftChild);
        int rightCheck = depth(node.rightChild);
        return Math.abs(leftCheck - rightCheck) < 2
                && checkHardBalance(node.leftChild) && checkHardBalance(node.rightChild);
    }

    private static int depth(Tree.TreeNode node) {
        if (node == null) return 0;
        return (1 + Math.max(depth(node.leftChild), depth(node.rightChild)));
    }

    public static boolean checkSoftBalance(Tree.TreeNode node){
        if (node == null) return true;
        int leftCheck = depth(node.leftChild);
        int rightCheck = depth(node.rightChild);
        return Math.abs(leftCheck - rightCheck) < 2;
    }
}
