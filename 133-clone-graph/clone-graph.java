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
        Map<Node,Node> oldToNew = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node); oldToNew.put(node, new Node(node.val));
        while(!q.isEmpty()){
            Node cur= q.remove();
            for(Node nb: cur.neighbors){
                if(!oldToNew.containsKey(nb)){
                    oldToNew.put(nb, new Node(nb.val));
                    q.add(nb);
                }
                oldToNew.get(cur).neighbors.add(oldToNew.get(nb));
            }
        }
        return oldToNew.get(node);
    }
}