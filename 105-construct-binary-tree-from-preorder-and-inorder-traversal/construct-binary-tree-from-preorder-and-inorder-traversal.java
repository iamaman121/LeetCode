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
    int preIdx;
    Map<Integer,Integer> map;
    private TreeNode buildTreeUtil(int[] preorder, int lo, int hi){
        if(lo>hi) return null;
        TreeNode root= new TreeNode(preorder[preIdx++]);
        int ind= map.get(root.val);
        root.left= buildTreeUtil(preorder, lo, ind-1);
        root.right= buildTreeUtil(preorder, ind+1, hi);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= inorder.length;
        map= new HashMap<>();
        for(int i=0;i<n;i++) map.put(inorder[i],i);
        preIdx=0;
        return buildTreeUtil(preorder, 0, n-1);
    }
}