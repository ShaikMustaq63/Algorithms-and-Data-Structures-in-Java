package com.rampatra.trees;

import com.rampatra.common.BinaryNode;
import com.rampatra.common.BinarySearchTree;
import com.rampatra.common.LinkedStack;
import com.rampatra.common.Stack;

import static java.lang.System.out;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: ramswaroop
 * @date: 6/26/15
 * @time: 7:31 PM
 */
public class InOrderUsingStack {

    /**
     * In-order traversal of tree using one stack and without recursion.
     *
     * @param node
     */
    public static <E extends Comparable<E>> void inOrderUsingStack(BinaryNode<E> node) {
        if (node == null) return;

        Stack<BinaryNode<E>> stack = new LinkedStack<>();

        BinaryNode<E> curr = node; // set root node as current node
        stack.push(curr); // push current node

        while (!stack.isEmpty()) {

            while (curr != null) {
                curr = curr.left;
                if (curr != null) stack.push(curr); // push all left nodes of the current node
            }

            BinaryNode<E> top = stack.pop();
            out.print(top.value); // print top of stack
            curr = top.right;
            if (curr != null) stack.push(curr); // push right child of top node
        }
    }

    public static void main(String a[]) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.put(6);
        bst.put(3);
        bst.put(5);
        bst.put(7);
        bst.put(8);
        bst.put(9);
        inOrderUsingStack(bst.root);
    }
}
