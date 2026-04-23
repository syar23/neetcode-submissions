/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

        //brute force
        if(root == null)
            return 0;
        
        int diameter = maxHeight(root.left)+maxHeight(root.right);
        int maxD = Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right));

        return Math.max(diameter, maxD);
        
    }

    private int maxHeight(TreeNode node) {
        if(node == null)
            return 0;
        
        return 1+Math.max(maxHeight(node.left),maxHeight(node.right));
    }
}
