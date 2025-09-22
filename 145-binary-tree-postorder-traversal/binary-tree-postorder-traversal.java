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
    private void postorderTraversalUtil(TreeNode root, List<Integer> postorder){
        if(root==null) return;
        postorderTraversalUtil(root.left, postorder);
        postorderTraversalUtil(root.right, postorder);
        postorder.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        postorderTraversalUtil(root, postorder);
        return postorder;
    }
}