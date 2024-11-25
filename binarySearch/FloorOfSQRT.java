package com.array.binarySearch;

public class FloorOfSQRT {
    public static void main(String[] args) {
        int x = 2147395599;
        int abs =func(1, x/2, x);
        System.out.println(abs);
    }

    private static int func(int low, int hi, int num){
        int ans = 0;
        int mid;
        while(low <= hi){
            mid = (low + hi) / 2;
            if(mid * mid <= num){
                ans = mid;
                low = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }
}
