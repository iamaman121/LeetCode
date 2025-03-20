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
    private void inOrder(TreeNode root, int[] ans){
        if(root==null) return;
        inOrder(root.left, ans);
        ans[0]--;
        if(ans[0]==0) ans[1]= root.val;
        inOrder(root.right, ans);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] ans= {k,-1};
        inOrder(root, ans);
        return ans[1];
    }
}