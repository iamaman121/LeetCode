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
    public static List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> preOrder = new ArrayList<>();
        preOrderTraversal(root, preOrder);
        return preOrder;
    }
    private static void preOrderTraversal(TreeNode root, List<Integer> preOrder){
        if(root==null) return;
        preOrder.add(root.val);
        preOrderTraversal(root.left, preOrder);
        preOrderTraversal(root.right, preOrder);
    }
    
}