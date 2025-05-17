/*
    https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        Node node = new Node(insertVal);
        if (head == null) {
            head = node;
            head.next = head;
            return head;
        }
        
        Node current = head;
        
        while (true) {
            Node next = current.next;

            // Case 1 : In-between insertion
            if (current.val <= insertVal && insertVal <= current.next.val) {
                break;
            }

            // Case 2 : We are at the 'tail -> head' junction.
            // Check if insertVal is either < smallest or > greatest
            if (current.val > next.val && (insertVal <= next.val || insertVal >= current.val)) {
                break;
            }

            current = next;

            // Case 3 : We have traversed through the list and not found a suitable position. 
            // So, all the numbers are identical and we can place the current number anywhere
            if (current == head) break;
        }

        node.next = current.next;
        current.next = node;

        return head;
    }
}