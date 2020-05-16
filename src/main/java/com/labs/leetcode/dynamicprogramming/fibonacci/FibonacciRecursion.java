package com.labs.leetcode.dynamicprogramming.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 斐波那契暴力版
 * 时间复杂度: O(2^n)
 * @Author: tanyun.zheng
 * @Date: 2020/5/16
 */
public class FibonacciRecursion {
    //求和
    long fib(int n){
        if(n==1 || n==2){
            return 1L;
        }
        return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        int n = 50;
        long start = System.currentTimeMillis();
        long r = new FibonacciRecursion().fib(n);
        long end = System.currentTimeMillis();
        System.out.println("Result:" + r + "  Cost:"+ (end-start));
    }
}
