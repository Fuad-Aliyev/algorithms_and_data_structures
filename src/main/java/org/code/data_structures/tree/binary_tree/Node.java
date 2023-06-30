package org.code.data_structures.tree.binary_tree;

public class Node {
    protected Node left;
    protected Node right;
    protected int key;

    public Node(int data) {
        this.key = data;
        left = right = null;
    }
}
