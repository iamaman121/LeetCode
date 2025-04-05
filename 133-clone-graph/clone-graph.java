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
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        Map<Node,Node> nodeCopy = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node); nodeCopy.put(node, new Node(node.val));
        Node curr, clone;
        while(!q.isEmpty()){
            curr= q.remove(); clone= nodeCopy.get(curr);
            for(Node nb: curr.neighbors){
                if(!nodeCopy.containsKey(nb)){
                    nodeCopy.put(nb, new Node(nb.val));
                    q.add(nb);
                }
                clone.neighbors.add(nodeCopy.get(nb));
            }
        }
        return nodeCopy.get(node);
    }
}