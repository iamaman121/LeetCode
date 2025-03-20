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
    Map<Integer,Integer> map;
    private TreeNode buildTreeUtil(int[] preorder, int sp, int ep, int[] inorder, int si, int ei){
        if(sp>ep) return null;
        int rVal= preorder[sp];
        int ind= map.get(rVal);
        int len1= ind-si;
        TreeNode root= new TreeNode(rVal);
        root.left= buildTreeUtil(preorder, sp+1, sp+len1, inorder, si, ind-1);
        root.right= buildTreeUtil(preorder, sp+len1+1, ep, inorder, ind+1, ei);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n= inorder.length;
        map= new HashMap<>();
        for(int i=0;i<n;i++) map.put(inorder[i],i);
        return buildTreeUtil(preorder, 0, n-1, inorder, 0, n-1);
    }
}