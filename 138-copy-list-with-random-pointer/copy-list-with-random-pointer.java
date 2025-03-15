/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    Map<Node,Node> map;
    private Node copy(Node A){
        Node B= new Node(A.val);
        map.put(A,B);
        return B;
    }
    private Node createCopyList(Node head){
        Node nhead= copy(head);
        Node temp= nhead;
        while(head.next!=null){
            nhead.next= copy(head.next);
            head=  head.next;
            nhead= nhead.next;
        }
        return temp;
    }
    private void setRandomPtr(Node A, Node B){
        while(A!=null){
            B.random= map.get(A.random);
            A= A.next;
            B= B.next;
        }
    }
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        map= new HashMap<>();
        Node nhead= createCopyList(head);
        setRandomPtr(head, nhead);
        return nhead;
    }
}