package com.linkedList;
import static com.linkedList.RemoveFromBack.create;
import static com.linkedList.RemoveFromBack.display;

public class ReverseNodesInKGroups {
    /*
    Since you do O(k) work for each of the n / k groups:
    ✔️ So the overall time complexity is O(n), where n is the number of nodes in the list.
     */
    public static void main(String[] args) {
        ListNode head = create(10);
//        display(head);
        ListNode ans = reverseInKGroups(head, 3);
        display(ans);
    }

    private static ListNode reverseInKGroups(ListNode head, int k) {
        ListNode prev = null, next = null;
        ListNode temp = head;
//
        while(temp != null) {
            ListNode kthNode = findKthNode(temp, k);
            if(kthNode == null) break;
            next = kthNode.next;
            kthNode.next = null;

            ListNode newHead = reverse(temp);

            if(temp == head){
                head = newHead;
            } else {
                prev.next = kthNode;
            }

            prev = temp;
            temp.next = next;
            temp = next;
        }
        return head;
    }

    private static ListNode reverse(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        head.next = null;
        while(p2!=null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }

        return p1;
    }

    private static ListNode findKthNode(ListNode head, int k) {
        ListNode temp = head;
        while(k - 1 > 0){
            if(temp == null) break;
            temp = temp.next;
            k--;
        }

        return temp;
    }
}
