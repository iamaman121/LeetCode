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
    private boolean isValidBSTUtil(TreeNode root, long minValue, long maxValue) {
        if(root==null) return true;
        long val= root.val;
        return val>minValue && val<maxValue
                && isValidBSTUtil(root.left, minValue, val) 
                    && isValidBSTUtil(root.right, val, maxValue);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}