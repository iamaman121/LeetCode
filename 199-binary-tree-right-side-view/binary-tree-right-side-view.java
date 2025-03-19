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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int level=-1;
        while(!q.isEmpty()){
            TreeNode curr, lft, rgt;
            int sz= q.size();
            level++;
            while(sz-->0){
                curr= q.poll();
                if(ans.size()==level){
                    ans.add(curr.val);
                }
                lft= curr.left;
                rgt= curr.right;
                if(rgt!=null) q.offer(rgt);
                if(lft!=null) q.offer(lft);
            }
        }
        return ans;
    }
}