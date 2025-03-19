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
    TreeNode lca;
    private int lowestCommonAncestorUtil(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return 0;
        int sum= ((root.val==p.val || root.val==q.val)?1:0);
        sum+= lowestCommonAncestorUtil(root.left, p, q);
        sum+= lowestCommonAncestorUtil(root.right, p, q);
        if(sum==2 && lca==null){
            lca= root;
        }
        return sum;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca= null;
        lowestCommonAncestorUtil(root, p, q);
        return lca;
    }
}