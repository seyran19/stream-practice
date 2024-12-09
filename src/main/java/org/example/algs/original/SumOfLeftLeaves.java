package org.example.algs.original;

public class SumOfLeftLeaves {

    private int result;


    public int sumOfLeftLeaves(TreeNode root) {
        while (root.right != null) {
            sum(root);
            root = root.right;
        }
        if (root.left != null) {
            sum(root);
        }
        return result;
    }


    private void sum(TreeNode node) {
        TreeNode treeNode = node;

        while (treeNode.left != null) {
            result += treeNode.left.val;
            treeNode = treeNode.left;

        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
