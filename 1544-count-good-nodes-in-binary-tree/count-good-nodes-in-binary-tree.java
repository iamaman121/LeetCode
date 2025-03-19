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
    private int goodNodesUtil(TreeNode root, int maxValue){
        if(root==null) return 0;
        int ans= root.val>=maxValue?1:0;
        maxValue= Math.max(maxValue,root.val);
        ans+= goodNodesUtil(root.left, maxValue);
        ans+= goodNodesUtil(root.right, maxValue);
        return ans;
    }
    public int goodNodes(TreeNode root) {
        return goodNodesUtil(root, Integer.MIN_VALUE);
    }
}