package com.labs.leetcode.dynamicprogramming.fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 斐波那契缓存版
 * 时间复杂度: O(n)
 * 空间复杂度: O(n)
 * @Author: tanyun.zheng
 * @Date: 2020/5/16
 */
public class FibonacciCache {
    public static void main(String[] args) {
        Map<Integer,Long> cache = new HashMap<>();
        int n = 50;
        long start = System.currentTimeMillis();
        long r = new FibonacciCache().fib(n, cache);
        long end = System.currentTimeMillis();
        System.out.println("Result:"+r+"  Cost:"+ (end-start));
    }
    long fib(int n,Map<Integer,Long> cache){
        //Map<Integer,Integer> cache = new HashMap<>();
        if(n==1 || n==2){
            cache.put(1,1L);
            cache.put(2,1L);
            return 1;
        }
        long t1 = null==cache.get(n-1)?fib(n-1,cache):cache.get(n-1);
        cache.put(n-1,t1);
        long t2 = null==cache.get(n-2)?fib(n-2,cache):cache.get(n-2);
        cache.put(n-2,t2);
        return t1+t2;
    }
}
