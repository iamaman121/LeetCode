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
    private void dfsTraversal(TreeNode root, List<String> res){
        if(root==null){
            res.add("N");
            return;
        }
        res.add(String.valueOf(root.val));
        dfsTraversal(root.left, res);
        dfsTraversal(root.right, res);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        dfsTraversal(root, res);
        return String.join(",", res);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals= data.split(",");
        int[] ind= {0};
        return deserializeDfs(vals, ind);
    }
    private TreeNode deserializeDfs(String[] vals, int[] ind){
        if(vals[ind[0]].equals("N")){
            ind[0]++;
            return null;
        }
        TreeNode root= new TreeNode(Integer.parseInt(vals[ind[0]++]));
        root.left= deserializeDfs(vals, ind);
        root.right= deserializeDfs(vals, ind);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));