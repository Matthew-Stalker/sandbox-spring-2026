package org.example.sandbox.trees.binarysearchtrees;

import org.example.sandbox.trees.Tree;

import java.util.Iterator;

public class BinarySearchTreeDriver {

    public static void main(String[] args) {

        Tree<Integer> bst = new BinarySearchTree<>();

        bst.insert(10);
        bst.insert(8);
        bst.insert(11);
        bst.insert(3);
        bst.insert(6);
        bst.insert(1);
        bst.insert(7);
        bst.insert(4);
        bst.insert(12);
        bst.insert(2);
        bst.insert(5);
        bst.insert(9);

        /*bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);
        bst.insert(6);
        bst.insert(7);
        bst.insert(8);
        bst.insert(9);
        bst.insert(10);
        bst.insert(11);
        bst.insert(12);*/

        System.out.println("In Order traversal of binary tree will be:");
        printTraversal(bst.iteratorInOrder());

        System.out.println("\nPost Order traversal of binary tree will be:");
        printTraversal(bst.iteratorPostOrder());

        System.out.println("\nPre Order traversal of binary tree will be:");
        printTraversal(bst.iteratorPreOrder());

        System.out.println("\nLevel Order traversal of binary tree will be:");
        printTraversal(bst.iteratorLevelOrder());
        
        System.out.println();
        ((BinarySearchTree<Integer>) bst).printTopDownTree();

        // bst.delete(8);

        // System.out.println();
        // ((BinarySearchTree<Integer>) bst).printTopDownTree();
      
    }

    private static void printTraversal(Iterator iterator) {

        while(iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj != null) {
                System.out.print(obj + " ");
            }
        }
    }
}