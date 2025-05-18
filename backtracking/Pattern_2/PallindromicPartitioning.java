package com.backtracking.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PallindromicPartitioning {
    public static void main(String[] args) {
        String s = "aaba";
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        func(s, 0, temp, res);
        System.out.println(res);
    }
    
    private static void func(String s, int indx, List<String> temp, List<List<String>> res) {
        if(indx == s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = indx; i < s.length(); i++) {
            if(isPallindrome(s, indx, i)) { // both i & indx including
                temp.add(s.substring(indx, i + 1));
                /*
                    we're slicing our string from indx to i + 1
                    that means our string to be partitioned from could be
                    "a" | aba, "aa" | ba, "aab | a
                    so if we have "aa" then in the next recursive call, we need to start
                    from i + 1, i.e. func("ba") not indx + 1, it would make repeated
                    strings
                 */
                func(s, i + 1, temp, res);
                temp.remove(temp.size() - 1);
            }
        }
    }
    
    private static boolean isPallindrome(String s, int i, int j) {
        while(i < j) {
            if(s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
}
