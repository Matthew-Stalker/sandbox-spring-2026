package org.example.sandbox.trees.binarysearchtrees;

import org.example.sandbox.trees.ElementNotFoundException;
import org.example.sandbox.trees.Tree;
import org.example.sandbox.trees.binarytrees.BinaryTree;

import java.util.*;

public class BinarySearchTree<T extends Comparable> implements Tree<T> {

    private BinaryTreeNode<T> root;
    private int count;

    public BinarySearchTree() {
        this.root = null;
        this.count = 0;
    }

    @Override
    public boolean create() {

        this.root = new BinaryTreeNode<>();

        return true;
    }

    @Override
    public T insert(T element) {

        T insertedElement = null;
        if (this.root == null) {
            this.root = new BinaryTreeNode(element);
            insertedElement = root.element;
        } else {
            insertedElement = insertInto(element, root);
        }
        return insertedElement;
    }

    private T insertInto(T element, BinaryTreeNode<T> root) {

        T insertedElement = null;
        if (element.compareTo(root.element) < 0) {
            if (root.left.element != null) {
                insertInto(element, root.left);
            } else {
                root.left.element = element;
                root.left.left = new BinaryTreeNode<>();
                root.left.right = new BinaryTreeNode<>();
                insertedElement = root.left.element;
            }
        } else {
            if (root.right.element != null) {
                insertInto(element, root.right);
            } else {
                root.right.element = element;
                root.right.left = new BinaryTreeNode<>();
                root.right.right = new BinaryTreeNode<>();
                insertedElement = root.right.element;
            }
        }
        return insertedElement;
    }

    @Override
    public T search(T targetElement) throws ElementNotFoundException {

        BinaryTreeNode<T> target = findNode(targetElement, root);

        if (target == null) {
            throw new ElementNotFoundException(this.getClass()
                                                   .getCanonicalName());
        }

        return (target.getElement());
    }

    private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) {

        // base case - didn't find what we're looking for
        if (next == null || next.getElement() == null) return null;

        // base case - found what we're looking for
        if (next.getElement().equals(targetElement)) return next;

        // use the BST property: go left iof target is smaller, right if larger or equal
        if (targetElement.compareTo(next.getElement()) < 0) {
            return findNode(targetElement, next.getLeft());
        }else {
            return findNode(targetElement, next.getRight());
        }

    }

    @Override
    public boolean delete(T data) {

        deleteNode(this.root, data);
        return true;
    }

    private BinaryTreeNode<T> deleteNode(BinaryTreeNode<T> root, T data) {

        if(root.element == null) return root;

        if(root.element.compareTo(data) > 0) {
            root.left = deleteNode(root.getLeft(), data);
        } else if(root.element.compareTo(data) < 0) {
            root.right = deleteNode(root.getRight(), data);
        } else {
            // node with no leaf nodes
            if(root.left.element == null && root.right.element == null) {

                root.left = null;
                root.right = null;
                root.element = null;
                return root;
            } else if(root.getLeft() == null) {

                // node with one node (no left node)
                return root.right;
            } else if(root.getRight() == null) {

                // node with one node (no right node)
                return root.left;
            } else {

                // nodes with two nodes
                // search for min number in right sub tree
                T minValue = minValue(root.right);
                root.element = minValue;
                root.right = deleteNode(root.right, minValue);
            }
        }

        return root;
    }

    private T minValue(BinaryTreeNode<T> node) {

        if(node.left.element != null) {
            return minValue(node.getLeft());
        }
        return node.element;
    }


    @Override
    public boolean contains(T targetElement) {
        boolean containsElement = false;

        try {
            containsElement = search(targetElement) != null;
        } catch (ElementNotFoundException e) {
            System.err.println("Element not found");
        }
        return containsElement;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public Iterator<T> iterator() {
        return iteratorLevelOrder();
    }

    public Iterator<T> iteratorPreOrder() {

        Queue<T> tempList = new LinkedList<>();
        preOrder(root, tempList);

        return tempList.iterator();
    }

    private void preOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        // Root, Left, Right
        if (node != null) {
            tempList.add(node.element);
            preOrder(node.left, tempList);
            preOrder(node.right, tempList);
        }
    }

    public Iterator<T> iteratorInOrder() {

        Queue<T> tempList = new LinkedList<>();
        inOrder(root, tempList);

        return tempList.iterator();
    }

    private void inOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        // Left, Root, Right
        if (node != null) {
            inOrder(node.left, tempList);
            tempList.add(node.element);
            inOrder(node.right, tempList);
        }
    }

    public Iterator<T> iteratorPostOrder() {

        Queue<T> tempList = new LinkedList<>();
        postOrder(root, tempList);

        return tempList.iterator();
    }

    private void postOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        // Left, Right, Root
        if (node != null) {
            postOrder(node.left, tempList);
            postOrder(node.right, tempList);
            tempList.add(node.element);
        }
    }

    public Iterator<T> iteratorLevelOrder() {

        Queue<T> tempList = new LinkedList<>();
        levelOrder(root, tempList);

        return tempList.iterator();
    }

    private void levelOrder(BinaryTreeNode<T> node, Queue<T> tempList) {

        // Temporary node queue
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        // while we have nodes to iterate...
        while (!queue.isEmpty()) {

            // store node value
            BinaryTreeNode<T> tempNode = queue.poll();
            tempList.add(tempNode.element);

            // store left node if not null
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            // store right node if not null
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }

    }

    private Iterator<BinaryTreeNode<T>> insertionIterator() {

        Queue<BinaryTreeNode<T>> tempList = new LinkedList<>();
        levelOrderInsertionIterator(root, tempList);

        return tempList.iterator();
    }

    private void levelOrderInsertionIterator(BinaryTreeNode<T> node, Queue<BinaryTreeNode<T>> tempList) {

        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {

            BinaryTreeNode<T> tempNode = queue.poll();
            tempList.add(tempNode);

            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }

        }
    }

    public void printTopDownTree() {

        List<List<String>> lines = new ArrayList<>();
        List<BinaryTreeNode<T>> level = new ArrayList<>();
        List<BinaryTreeNode<T>> next = new ArrayList<>();

        level.add(this.root);
        int nn = 1;

        int widest = 0;

        while (nn != 0) {
            List<String> line = new ArrayList<>();

            nn = 0;

            for (BinaryTreeNode<T> n : level) {

                if (n == null) {
                    line.add(null);
                    next.add(null);
                    next.add(null);
                } else {
                    String aa;
                    if (n.getElement() != null) {
                        aa = n.getElement()
                              .toString();
                    } else {
                        aa = "null";
                    }
                    line.add(aa);
                    if (aa.length() > widest) widest = aa.length();

                    next.add(n.getLeft());
                    next.add(n.getRight());

                    if (n.getLeft() != null) nn++;
                    if (n.getRight() != null) nn++;

                }
            }

            if (widest % 2 == 1) widest++;

            lines.add(line);

            List<BinaryTreeNode<T>> tmp = level;
            level = next;
            next = tmp;
            next.clear();
        }

        int perPiece = lines.get(lines.size() - 1)
                            .size() * (widest + 4);
        for (int i = 0; i < lines.size(); i++) {
            List<String> line = lines.get(i);
            int hpw = (int) Math.floor(perPiece / 2f) - 1;

            if (i > 0) {
                for (int j = 0; j < line.size(); j++) {

                    // split node
                    char c = ' ';
                    if (j % 2 == 1) {
                        if (line.get(j - 1) != null) {
                            c = (line.get(j) != null) ? '|' : '|';
                        } else {
                            if (j < line.size() && line.get(j) != null) c = '|';
                        }
                    }
                    System.out.print(c);

                    // lines and spaces
                    if (line.get(j) == null) {
                        for (int k = 0; k < perPiece - 1; k++) {
                            System.out.print(" ");
                        }
                    } else {

                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? " " : "-");
                        }
                        System.out.print(j % 2 == 0 ? "|" : "|");
                        for (int k = 0; k < hpw; k++) {
                            System.out.print(j % 2 == 0 ? "-" : " ");
                        }
                    }
                }
                System.out.println();
            }

            // print line of numbers
            for (int j = 0; j < line.size(); j++) {

                String f = line.get(j);
                if (f == null) f = "";
                int gap1 = (int) Math.ceil(perPiece / 2f - f.length() / 2f);
                int gap2 = (int) Math.floor(perPiece / 2f - f.length() / 2f);

                // a number
                for (int k = 0; k < gap1; k++) {
                    System.out.print(" ");
                }
                System.out.print(f);
                for (int k = 0; k < gap2; k++) {
                    System.out.print(" ");
                }
            }
            System.out.println();

            perPiece /= 2;
        }
    }

    private static class BinaryTreeNode<S> {

        BinaryTreeNode<S> left;
        BinaryTreeNode<S> right;
        S element;

        BinaryTreeNode() {
            this.element = null;
            this.left = null;
            this.right = null;
        }

        BinaryTreeNode(S element) {
            this.element = element;
            this.left = new BinaryTreeNode<>();
            this.right = new BinaryTreeNode<>();
        }

        S getElement() {
            return element;
        }

        BinaryTreeNode<S> getLeft() {
            return left;
        }

        BinaryTreeNode<S> getRight() {
            return right;
        }

    }

}