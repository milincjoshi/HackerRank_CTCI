//Linked Lists: Detect a Cycle 


/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {

    if(head == null || head.next == null || head.next.next == null){
        return false;
    }
    
    Node slow = head;
    Node fast = head;
    
    while(true){

        if(slow.next == null || fast.next.next == null){
            return false;
        }

        slow = slow.next;
        fast = fast.next.next;
        
        if(slow == fast){
           return true;
        }
    }
   
}
