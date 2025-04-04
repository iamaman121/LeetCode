/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> getClone= new HashMap<>();
    HashSet<Node> vis= new HashSet<>();
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        if(vis.contains(node)){
            return getClone.get(node);
        }
        vis.add(node);
        Node clone = new Node(node.val);
        getClone.put(node,clone);
        for(Node n: node.neighbors){
            clone.neighbors.add(cloneGraph(n));
        }
        return clone;
    }
}