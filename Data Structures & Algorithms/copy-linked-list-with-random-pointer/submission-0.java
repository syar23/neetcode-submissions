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
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // 1) Create cloned nodes and weave them in.
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }

        // 2) Assign random pointers for the copies.
        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        // 3) Unweave to separate original and copied lists.
        Node dummy = new Node(0);
        Node copyCur = dummy;
        cur = head;

        while (cur != null) {
            Node copy = cur.next;
            Node nextOrig = copy.next;

            copyCur.next = copy;
            copyCur = copy;

            cur.next = nextOrig; // restore original
            cur = nextOrig;
        }

        return dummy.next;
    
    }
}
