/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    private TreeNode lowestCommonAncestorUtil(TreeNode root, int pval, int qval) {
        int val= root.val;
        if(pval>val && qval>val){
            return lowestCommonAncestorUtil(root.right, pval, qval);
        }
        else if(pval<val && qval<val){
            return lowestCommonAncestorUtil(root.left, pval, qval);
        }
        else{
            return root;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return lowestCommonAncestorUtil(root, p.val, q.val);
    }
}