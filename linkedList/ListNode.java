package com.linkedList;

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val; this.next = next;
    }

    public static ListNode ll1(){
        ListNode list1 = new ListNode(-9);
        list1.next = new ListNode(3);
        return list1;
    }

    public static ListNode ll2(){
        ListNode list2 = new ListNode(5);
        list2.next = new ListNode(7);
        return list2;
    }

    public static ListNode ll3(){
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(2);
        list2.next.next = new ListNode(3);
        list2.next.next.next = new ListNode(4);
        return list2;
    }

    public static ListNode pallinLL4() {
        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(7);
        list2.next.next.next = new ListNode(3);
        list2.next.next.next.next = new ListNode(2);
        list2.next.next.next.next.next = new ListNode(12);
        list2.next.next.next.next.next.next = new ListNode(24);
        return list2;
    }
}
