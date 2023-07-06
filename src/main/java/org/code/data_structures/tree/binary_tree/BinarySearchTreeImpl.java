package org.code.data_structures.tree.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTreeImpl implements BinarySearchTree {
    private Node root;

    public Node getRoot() {
        return root;
    }

    BinarySearchTreeImpl() {
        root = null;
    }

    //delete a node from BST
    @Override
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

    @Override
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

    @Override
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

    @Override
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

    @Override
    public List<Integer> breadthFirstSearch() {
        Node currentNode = this.root;
        List<Integer> list = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            System.out.println(currentNode.key);
            list.add(currentNode.key);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        System.out.println(list);
        return list;
    }

    @Override
    public List<Integer> breadthFirstSearchRecursive(Queue<Node> queue, List<Integer> list) {
        if (queue.size() == 0) return list;
        Node currentNode = queue.remove();
        list.add(currentNode.key);
        if (currentNode.left != null) {
            queue.add(currentNode.left);
        }
        if (currentNode.right != null) {
            queue.add(currentNode.right);
        }
        return breadthFirstSearchRecursive(queue, list);
    }

    @Override
    public List<Integer> depthFirstSearchInOrderRecursive(Node node, List<Integer> list) {
        if (node.left != null) {
            depthFirstSearchInOrderRecursive(node.left, list);
        }
        list.add(node.key);
        if (node.right != null) {
            depthFirstSearchInOrderRecursive(node.right, list);
        }
        return list;
    }

    @Override
    public List<Integer> depthFirstSearchPreOrderRecursive(Node node, List<Integer> list) {
        list.add(node.key);
        if (node.left != null) {
            depthFirstSearchPreOrderRecursive(node.left, list);
        }
        if (node.right != null) {
            depthFirstSearchPreOrderRecursive(node.right, list);
        }
        return list;
    }

    @Override
    public List<Integer> depthFirstSearchPostOrderRecursive(Node node, List<Integer> list) {
        if (node.left != null) {
            depthFirstSearchPostOrderRecursive(node.left, list);
        }
        if (node.right != null) {
            depthFirstSearchPostOrderRecursive(node.right, list);
        }
        list.add(node.key);
        return list;
    }
}
