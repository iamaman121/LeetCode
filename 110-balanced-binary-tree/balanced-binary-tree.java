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
    boolean balanced;
    private int height(TreeNode root) {
        if(!balanced || root==null) return 0;
        int lft= height(root.left);
        int rgt= height(root.right);
        if(Math.abs(lft-rgt)>1 && balanced) balanced=false;
        return Math.max(lft,rgt)+1;
    }
    public boolean isBalanced(TreeNode root) {
        balanced= true;
        height(root);
        return balanced;
    }
}