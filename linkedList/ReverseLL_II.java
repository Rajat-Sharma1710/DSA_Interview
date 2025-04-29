package com.linkedList;
import static com.linkedList.RemoveFromBack.create;
import static com.linkedList.RemoveFromBack.display;

public class ReverseLL_II {
    public static void main(String[] args) {
        ListNode head = create(4);

        ListNode ans = reverse(head, 1, 5);
        display(ans);
    }

    private static ListNode reverse(ListNode head, int left, int right) {
        // edge cases
        if(head == null || head.next == null) return head;
        if(left == right) return head;

        // find first after end of window
        ListNode firstAfterWindow = getTail(head, right);
        // find first before start of window
        ListNode oneBeforeLeft = null;
        ListNode leftNode = head;
        int temp_left = left;
        while(temp_left - 1 > 0) {
            oneBeforeLeft = leftNode;
            leftNode = leftNode.next;
            temp_left--;
        }
        ListNode p1 = leftNode;
        ListNode p2 = leftNode.next;
        // attach left node to tail
        p1.next = firstAfterWindow;

        // reverse the window from left to right
        int diff = right - left;
        while(diff > 0) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
            diff--;
        }
        // attach first node of the reversed LL (which was the last node of the ori ll)
        // to the oneBeforeLeft
        if(oneBeforeLeft != null)
            oneBeforeLeft.next = p1;
        else head = p1;

        return head;
    }

    private static ListNode getTail(ListNode head, int right) {
        ListNode temp = head;
        while(right-- > 0) {
            temp = temp.next;
        }

        return temp;
    }
}
