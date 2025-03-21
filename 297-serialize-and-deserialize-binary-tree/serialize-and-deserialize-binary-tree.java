/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "N";
        StringBuilder sb= new StringBuilder();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        TreeNode curr;
        while(!q.isEmpty()){
            curr= q.poll();
            if(curr!=null){
                sb.append(curr.val).append(",");
                q.add(curr.left);
                q.add(curr.right);
            }
            else sb.append("N,");
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals= data.split(",");
        if(vals[0].equals("N")) return null;
        TreeNode root= new TreeNode(Integer.parseInt(vals[0]));
        int idx=1;
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        TreeNode node;
        while(!q.isEmpty()){
            node= q.poll();
            if(!vals[idx].equals("N")){
                node.left= new TreeNode(Integer.parseInt(vals[idx]));
                q.add(node.left);
            }
            idx++;
            if(!vals[idx].equals("N")){
                node.right= new TreeNode(Integer.parseInt(vals[idx]));
                q.add(node.right);
            }
            idx++;
        } 
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));