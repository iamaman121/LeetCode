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
    int cnt;
    TreeNode ans;
    private void inOrder(TreeNode root, int k){
        if(root==null) return;
        inOrder(root.left, k);
        cnt++;
        if(cnt==k) ans= root;
         inOrder(root.right, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        cnt=0; ans=null;
        inOrder(root, k);
        return ans.val;
    }
}