// 
// Decompiled by Procyon v0.5.36
// 

package hw3;

import java.util.Queue;
import java.util.LinkedList;

public class GenericBinaryTree
{
    public void insertIntoGenericBinaryTree(BinaryTreeNode root, final int data) {
        final BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.x = data;
        final BinaryTreeNode binaryTreeNode = newNode;
        final BinaryTreeNode binaryTreeNode2 = newNode;
        final BinaryTreeNode binaryTreeNode3 = null;
        binaryTreeNode2.rightNode = binaryTreeNode3;
        binaryTreeNode.leftNode = binaryTreeNode3;
        if (root == null) {
            root = newNode;
            return;
        }
        Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(root);
        while (q.peek() != null) {
            final BinaryTreeNode tempNode = q.poll();
            if (tempNode.leftNode == null) {
                tempNode.leftNode = newNode;
                q = null;
                return;
            }
            q.add(tempNode.leftNode);
            if (tempNode.rightNode == null) {
                tempNode.rightNode = newNode;
                q = null;
                return;
            }
            q.add(tempNode.rightNode);
        }
    }
    
    public void levelOrderTraverse(final BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        final Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
        q.add(root);
        while (q.peek() != null) {
            final BinaryTreeNode tempNode = q.poll();
            System.out.println(tempNode.x);
            if (tempNode.leftNode != null) {
                q.add(tempNode.leftNode);
            }
            if (tempNode.rightNode != null) {
                q.add(tempNode.rightNode);
            }
        }
    }
    
    public String levelOrderStringTraversal(final BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        final String leftSubTree = this.levelOrderStringTraversal(root.leftNode);
        final String rightSubTree = this.levelOrderStringTraversal(root.rightNode);
        return invokedynamic(makeConcatWithConstants:(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;, root.x, leftSubTree, rightSubTree);
    }
    
    public void insertIntoGenericBinaryTree(BinaryTreeNode root, final int data, final String path) {
        final char[] pathArr = path.toCharArray();
        final int loopCount = pathArr.length - 1;
        final BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.x = data;
        final BinaryTreeNode binaryTreeNode = newNode;
        final BinaryTreeNode binaryTreeNode2 = newNode;
        final BinaryTreeNode binaryTreeNode3 = null;
        binaryTreeNode2.rightNode = binaryTreeNode3;
        binaryTreeNode.leftNode = binaryTreeNode3;
        int i;
        for (i = 0; i < loopCount; ++i) {
            if (pathArr[i] == 'l') {
                root = root.leftNode;
            }
            else {
                if (pathArr[i] != 'r') {
                    return;
                }
                root = root.rightNode;
            }
        }
        if (pathArr[i] == 'l') {
            root.leftNode = newNode;
        }
        else {
            root.rightNode = newNode;
        }
    }
}
