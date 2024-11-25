package com.linkedList;

public class Creation {
    private static Node insertNode(Node head,int val) {
        Node newNode = new Node(val);

        if(head == null) {
            head = newNode;
            return head;
        }

        Node temp = head;
        while(temp.next != null) temp = temp.next;

        temp.next = newNode;
        return head;
    }
    public static void main(String[] args) {
        Node head = null;
        head=insertNode(head,1);
        head=insertNode(head,3);
        head=insertNode(head,1);
        head=insertNode(head,2);
        head=insertNode(head,4);
        Node head1 = head;
        head = head.next.next.next;

        Node secHead = null;
        secHead = insertNode(secHead, 3);
        Node head2 = secHead;
        secHead.next = head;

        Node ans = findIntersection(head1, head2);
        System.out.println(ans.val);
    }

    private static Node findIntersection(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;

        while(temp1 != temp2){
            temp1 = temp1 == null ? head2 : temp1.next;
            temp2 = temp2 == null ? head1 : temp2.next;
        }
        return temp2;
    }
}
class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
        next = null;
    }
}
