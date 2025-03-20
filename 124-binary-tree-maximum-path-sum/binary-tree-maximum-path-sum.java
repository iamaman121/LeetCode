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
    int ans;
    private int maxPathSumUtil(TreeNode root){
        if(root==null) return 0;
        int lft= Math.max(maxPathSumUtil(root.left),0);
        int rgt= Math.max(maxPathSumUtil(root.right),0);
        int val= root.val;
        ans=Math.max(ans,lft+rgt+val);
        return val+Math.max(lft,rgt);
    }
    public int maxPathSum(TreeNode root) {
        ans= Integer.MIN_VALUE;
        maxPathSumUtil(root);
        return ans;
    }
}