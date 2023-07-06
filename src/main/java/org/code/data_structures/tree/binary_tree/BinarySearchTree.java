package org.code.data_structures.tree.binary_tree;

import java.util.List;
import java.util.Queue;

public interface BinarySearchTree {
    void deleteKey(int key);

    void insert(int key);

    void inorder();

    boolean search(int key);

    List<Integer> breadthFirstSearch();

    List<Integer> breadthFirstSearchRecursive(Queue<Node> queue, List<Integer> list);

    List<Integer> depthFirstSearchInOrderRecursive(Node node, List<Integer> list);

    List<Integer> depthFirstSearchPreOrderRecursive(Node node, List<Integer> list);

    List<Integer> depthFirstSearchPostOrderRecursive(Node node, List<Integer> list);
}
