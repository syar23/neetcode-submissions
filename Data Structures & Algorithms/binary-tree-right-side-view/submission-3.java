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
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return res;
        dfs(root,0);
        return res;
        
    }

    private void dfs(TreeNode root, int depth){
        if(root != null) {
            if(res.size()==depth)
                res.add(root.val);
            dfs(root.right,depth+1);
            dfs(root.left,depth+1);
        } else {
            return;
        }
    }
}
