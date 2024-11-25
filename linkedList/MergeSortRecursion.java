package com.linkedList;

import java.util.List;

import static com.linkedList.ListNode.ll1;
import static com.linkedList.ListNode.ll2;

public class MergeSortRecursion {
    public static void main(String[] args) {
        mergeUsingRecursion(ll1(), ll2());
    }

    private static ListNode mergeUsingRecursion(ListNode listNode, ListNode listNode1) {
        if(listNode == null){
            return listNode1;
        }
        if(listNode1 == null){
            return listNode;
        }
        ListNode res;
        if(listNode.val <= listNode1.val){
            res = listNode;
            res.next = mergeUsingRecursion(res.next, listNode1);
        } else {
            res = listNode1;
            res.next = mergeUsingRecursion(listNode, res.next);
        }
        return res;
    }
}
