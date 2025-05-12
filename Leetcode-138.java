/*
    https://leetcode.com/problems/copy-list-with-random-pointer/
*/

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
    /**
     * Time complexity : O(2*N)
     * Space complexity : O(N)
     */
     /*
    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(-1);
        Node current = dummyHead;
        Map<Node, Node> origToNew = new HashMap<>();

        Node origNode = head;
        while (origNode != null) {
            Node node = new Node(origNode.val);
            origToNew.put(origNode, node);
            current.next = node;
            current = current.next;
            origNode = origNode.next;
        }

        origNode = head;
        current = dummyHead.next;
        while (origNode != null) {
            Node newNode = origToNew.get(origNode.random);
            current.random = newNode;
            current = current.next;
            origNode = origNode.next;
        }

        return dummyHead.next;
    }
    */

    /**
     * Time complexity : O(3*N) => O(N)
     * Space complexity : O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1 : Create new nodes and stitch them into current list
        Node current = head;
        while (current != null) {
            Node node = new Node(current.val);
            node.next = current.next;
            current.next = node;
            current = current.next.next;
        }

        // Step 2 : Assign random pointers to the newly added nodes
        current = head;
        while (current != null) {
            Node deepCopy = current.next;
            if (current.random != null) deepCopy.random = current.random.next;
            current = current.next.next;
        }

        // Step 3 : Unstitch the newly added nodes from the original list
        Node dummyHead = new Node(-1);
        Node newCurrent = dummyHead;
        current = head;
        
        while (current != null) {
            newCurrent.next = current.next;
            current.next = current.next.next;
            newCurrent = newCurrent.next;
            current = current.next;    
        }

        return dummyHead.next;
    }
}