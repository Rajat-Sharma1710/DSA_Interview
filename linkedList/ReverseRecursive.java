package com.linkedList;

public class ReverseRecursive {
    public static void main(String[] args) {
        ListNode head = ListNode.ll3();

        ListNode temp = reverse(head);

        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = reverse(head.next);
        /*
            Now, suppose we have 3 elements
            1 -> 2 -> 3, now 2 -> 3 subLL will return 2 <- 3 wherein 3 is the newHead
            now, we need to just reverse the pointer of 1 -> 2 to 1 <- 2
         */

        ListNode originalHeadNext = head.next;
        // reverse pointer
        originalHeadNext.next = head;
        // make original's head next to null
        head.next = null;
        return newHead;
    }
}
