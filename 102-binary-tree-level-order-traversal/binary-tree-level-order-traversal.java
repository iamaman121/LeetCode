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
        List<List<Integer>> levelOrderList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root==null) return levelOrderList;
        q.add(root);
        while(!q.isEmpty()){
            int siz = q.size();
            List<Integer> temp = new ArrayList<>();
            while(siz-->0){
                TreeNode rem = q.remove();
                temp.add(rem.val);
                if(rem.left!=null){
                    q.add(rem.left);
                }
                if(rem.right!=null){
                    q.add(rem.right);
                }
            }
            levelOrderList.add(temp);
        }
        return levelOrderList;
    }
}