package com.linkedList;

public class longestPallindromicLL {
    public static void main(String[] args) {
        ListNode head = ListNode.pallinLL4();
        int res = maxPalindrome(head);
        System.out.println(res);
    }

    public static int maxPalindrome(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        int max = Integer.MIN_VALUE;
        while(curr != null) {
            ListNode next = curr.next;
            Pair p = findPairs(curr, prev);
            if(p.isOdd){
                max = Math.max(max, (2*p.pairs) + 1);
            } else {
                max = Math.max(max, 2*p.pairs);
            }

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return max;
    }?

    private static Pair findPairs(ListNode curr, ListNode prev) {
        int oddPairs = 0;

        ListNode curr1 = curr;
        ListNode prev1 = prev;

        while(curr1.next != null && prev1 != null && curr1.next.val == prev1.val) {
            oddPairs++;
            curr1 = curr1.next;
            prev1 = prev1.next;
        }

        curr1 = curr;
        prev1 = prev;

        int evenPairs = 0;
        while(curr1 != null && prev1 != null && curr1.val == prev1.val) {
            evenPairs++;
            curr1 = curr1.next;
            prev1 = prev1.next;
        }
        Pair p = new Pair(Math.max(oddPairs, evenPairs), false);
        if(oddPairs >= evenPairs) p.isOdd = true;
        return p;
    }

    static class Pair {
        int pairs;
        boolean isOdd;

        public Pair(int pairs, boolean isOdd) {
            this.pairs = pairs;
            this.isOdd = isOdd;
        }
    }
}
