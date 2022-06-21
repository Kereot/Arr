package ru.geekbrains.jads.les6;

import lombok.Getter;

// Это почти полная копия дерева с урока;
// Убраны коты, и немного по мелочи для задания.
public class Tree {
    public class TreeNode {
        private int insert;
        public TreeNode leftChild;
        public TreeNode rightChild;

        public TreeNode(int insert) {
            this.insert = insert;
        }
    }
    @Getter
    private TreeNode root;
    public Tree() {
        root = null;
    }
    public void insert(int insert) {
        TreeNode node = new TreeNode(insert);
        if (root == null) {
            root = node;
        } else {
            TreeNode current = root;
            TreeNode parent;
            while (true) {
                parent = current;
                if (insert < current.insert) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = node;
                        return;
                    }
                } else if (insert > current.insert){
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = node;
                        return;
                    }
                } else {
                    return;
                }
            }

        }
    }
    public Integer find(int insert) {
        TreeNode current = root;
        while (current.insert != insert) {
            if (insert < current.insert)
                current = current.leftChild;
            else
                current = current.rightChild;

            if (current == null)
                return null;
        }
        return current.insert;
    }
    private void inOrderTravers(TreeNode current) {
        if (current != null) {
            System.out.println(current.insert);
            inOrderTravers(current.leftChild);
            inOrderTravers(current.rightChild);
        }
    }
    public void displayTree() {
        inOrderTravers(root);
    }
    public boolean delete(Integer insert) {
        TreeNode curr = root;
        TreeNode prev = root;
        boolean isLeftChild = true;
        while (curr.insert != insert) {
            prev = curr;
            if (insert < curr.insert) {
                isLeftChild = true;
                curr = curr.leftChild;
            } else {
                isLeftChild = false;
                curr = curr.rightChild;
            }

            if (curr == null)
                return false;
        }

        if (curr.leftChild == null && curr.rightChild == null) {
            if (curr == root) {
                root = null;
            } else if (isLeftChild) {
                prev.leftChild = null;
            } else {
                prev.rightChild = null;
            }
        } else if (curr.rightChild == null) {
            if (isLeftChild) {
                prev.leftChild = curr.leftChild;
            } else {
                prev.rightChild = curr.leftChild;
            }
        } else if (curr.leftChild == null) {
            if (isLeftChild) {
                prev.leftChild = curr.rightChild;
            } else {
                prev.rightChild = curr.rightChild;
            }
        } else {
            TreeNode successor = getSuccessor(curr);
            if (curr == root) {
                root = successor;
            } else if (isLeftChild) {
                prev.leftChild = successor;
            } else {
                prev.rightChild = successor;
            }
            successor.leftChild = curr.leftChild;
        }
        return true;
    }

    private TreeNode getSuccessor(TreeNode deleted) {
        TreeNode successorParent = deleted;
        TreeNode successor = deleted;
        TreeNode flag = deleted.rightChild;

        while (flag != null) {
            successorParent = successor;
            successor = flag;
            flag = flag.leftChild;
        }
        if (successor != deleted.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = deleted.rightChild;
        }
        return successor;
    }

}
