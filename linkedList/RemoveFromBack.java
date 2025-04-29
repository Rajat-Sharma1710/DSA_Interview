package com.linkedList;

public class RemoveFromBack {
    public static void main(String[] args) {
        ListNode head = create(4);
        ListNode ans = removeFromBack(head, 2);
        display(ans);
    }

    public static ListNode create(int n) {
        ListNode head = new ListNode(1);
        ListNode temp = head;
        int val = 2;
        while(n-- > 0){
            temp.next = new ListNode(val);
            temp = temp.next;
            val++;
        }
        return head;
    }

    private static ListNode removeFromBack(ListNode head, int n) {
        if(head == null || head.next == null) return null;

        int size = findSize(head);
        int nFromFront = size - n;

        ListNode prev = null;
        ListNode curr = head;

        while(nFromFront-- > 0) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        return head;
    }

    private static int findSize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while(temp != null) {
            size++;
            temp = temp.next;
        }

        return size;
    }

    public static void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
}
