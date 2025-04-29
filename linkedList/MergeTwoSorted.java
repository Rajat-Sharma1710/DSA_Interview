package com.linkedList;

import static com.linkedList.ListNode.ll1;
import static com.linkedList.ListNode.ll2;

public class MergeTwoSorted {
    public static void main(String[] args) {

        ListNode newNode = mergeTwoLists(ll1(), ll2());

        // To Print input list list1 and list2
        ListNode temp2 = ll2();
        ListNode temp1 = ll1();
        System.out.print("list1 => ");
        while(temp1 != null){
            System.out.print(temp1.val + " ");
            temp1 = temp1.next;
        }
        System.out.println();
        System.out.print("list2 => ");
        while(temp2 != null){
            System.out.print(temp2.val + " ");
            temp2 = temp2.next;
        }
        System.out.println();
        // To Print output list
        while(newNode != null){
            System.out.print(newNode.val + " ");
            newNode = newNode.next;
        }
    }

    private static ListNode merge(ListNode head1, ListNode head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }

        ListNode headNew, p3;
        ListNode p1 = head1;
        ListNode p2 = head2;

        if (p1.val <= p2.val) {
            headNew = p1;
            p1 = p1.next;
        } else {
            headNew = p2;
            p2 = p2.next;
        }
        p3 = headNew;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p3.next = p1;
                p1 = p1.next;
            } else {
                p3.next = p2;
                p2 = p2.next;
            }
            p3 = p3.next;
        }

        while (p1 != null) {
            p3.next = p1;
            p1 = p1.next;
        }

        while (p2 != null) {
            p3.next = p2;
            p2 = p2.next;
        }

        return headNew;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }

        while(l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }

        while(l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }

        return head.next;
    }
}
