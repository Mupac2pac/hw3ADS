// 
// Decompiled by Procyon v0.5.36
// 

package hw3;

public class GenericBinaryTreeUser
{
    public static void main(final String[] args) {
        final GenericBinaryTree gbt = new GenericBinaryTree();
        final BinaryTreeNode root = new BinaryTreeNode();
        root.x = 5;
        gbt.insertIntoGenericBinaryTree(root, 3, "l");
        gbt.insertIntoGenericBinaryTree(root, 4, "ll");
        gbt.insertIntoGenericBinaryTree(root, 6, "lll");
        gbt.insertIntoGenericBinaryTree(root, 10, "r");
        gbt.insertIntoGenericBinaryTree(root, 11, "rr");
        gbt.insertIntoGenericBinaryTree(root, 13, "rrr");
        gbt.insertIntoGenericBinaryTree(root, 12, "rl");
        gbt.insertIntoGenericBinaryTree(root, 21, "rll");
        gbt.insertIntoGenericBinaryTree(root, 20, "rlr");
        gbt.insertIntoGenericBinaryTree(root, 22, "rlrr");
        gbt.insertIntoGenericBinaryTree(root, 23, "rlrrr");
        gbt.insertIntoGenericBinaryTree(root, 24, "rlrrrl");
        System.out.println(gbt.levelOrderStringTraversal(root));
    }
}
