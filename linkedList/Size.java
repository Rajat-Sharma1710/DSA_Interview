package com.linkedList;

public class Size {
    public static void main(String[] args) {
        ListNode head = ListNode.ll3(); // 1 -> 2 -> 3 -> 4
        head = reverse(head);

        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    private static ListNode reverse(ListNode newHead) {
        ListNode prev = null;
        ListNode curr = newHead;

        while(curr != null) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
