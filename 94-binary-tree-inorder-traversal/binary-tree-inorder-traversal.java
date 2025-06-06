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
    public static List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> inOrder = new ArrayList<>();
        inorderTraversal(root, inOrder);
        return inOrder;
    }
    private static void inorderTraversal(TreeNode root, List<Integer> inOrder){
        if(root==null) return;
        inorderTraversal(root.left, inOrder);
        inOrder.add(root.val);
        inorderTraversal(root.right, inOrder);
    }
}