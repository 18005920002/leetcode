package com.labs.leetcode.dynamicprogramming.fibonacci;

/**
 * @Description: 斐波那契 动态规划版
 * 时间复杂度: O(n)
 * 空间复杂度: O(1)
 * @Author: tanyun.zheng
 * @Date: 2020/5/16
 */
public class FibonacciDP {
    public long fib(int n) {
        long[] store = {1,1};
        if(n==1 || n==2){
            return 1;
        }
        long r = 0;
        for(int i=2;i<n;i++){
            long a = store[0];
            long b = store[1];
            r = a + b;
            store[0] = store[1];
            store[1] = r;
        }
        return r;
    }

    public static void main(String[] args) {
        int n = 50;
        long start = System.currentTimeMillis();
        long r = new FibonacciDP().fib(n);
        long end = System.currentTimeMillis();
        System.out.println("Result:"+r+"  Cost:"+ (end-start));
    }
}
