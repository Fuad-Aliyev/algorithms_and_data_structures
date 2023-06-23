package org.code.tree.binary_tree;

public class BinarySearchTree {
    private Node root;

    BinarySearchTree() {
        root = null;
    }

    //delete a node from BST
    public void deleteKey(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node root, int key) {
        if (root == null) return root;
        if (key < root.key)
            root.left = deleteRecursive(root.left, key);
        else if (key > root.key)
            root.right = deleteRecursive(root.right, key);
        else {
            //node contains only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node has two children
            //get inorder successor (min value in the right subtree)
            root.key = minValue(root.right);
            // Delete the inorder successor
            root.right = deleteRecursive(root.right, root.key);
        }
        return root;
    }

    private int minValue(Node root) {
        int minVal = root.key;
        while (root.left != null) {
            minVal = root.left.key;
            root = root.left;
        }
        return minVal;
    }

    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    private Node insertRecursive(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.key)
            root.left = insertRecursive(root.left, key);
        else if (key > root.key)
            root.right = insertRecursive(root.right, key);
        return root;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.println(root.key + " ");
            inorderRecursive(root.right);
        }
    }

    public boolean search(int key) {
        root = searchRecursive(root, key);
        if (root != null)
            return true;
        else
            return false;
    }

    private Node searchRecursive(Node root, int key) {
        if (root == null || root.key == key)
            return root;
        if (root.key > key)
            return searchRecursive(root.left, key);
        return searchRecursive(root.right, key);
    }
}
