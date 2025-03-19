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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> bfsTraversal= new ArrayList<>();
        if(root==null) return bfsTraversal;
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        List<Integer> level;
        while(!q.isEmpty()){
            int sz= q.size();
            TreeNode curr, lft, rgt;
            level= new ArrayList<>();
            while(sz-->0){
                curr= q.poll();
                level.add(curr.val);
                lft= curr.left;
                rgt= curr.right;
                if(lft!=null) q.offer(lft);
                if(rgt!=null) q.offer(rgt);
            }
            bfsTraversal.add(level);
        }
        return bfsTraversal;
    }
}