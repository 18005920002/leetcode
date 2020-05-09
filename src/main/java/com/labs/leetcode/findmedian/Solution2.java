package com.labs.leetcode.findmedian;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/5/8
 */
public class Solution2 {
    public static void main(String[] args) {
        int[] arrayA = {1,2};
        int[] arrayB = {3,4};
        System.out.println(new Solution2().findMedianSortedArrays(arrayA,arrayB));
    }

    public double findMedianSortedArrays(int[] arrayA, int[] arrayB) {
        int m = arrayA.length;
        int n = arrayB.length;
        int halfLen = (m + n + 1)/2;

        if(m>n){
            int temp[]=arrayA;
            arrayA = arrayB;
            arrayB = temp;
            int t=m;
            m = n;
            n = t;
        }
        int iMin = 0;
        int iMax = m;
        while (iMin <= iMax){
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            System.out.println("iMin="+iMin+" iMax="+iMax+" i="+i+" j="+j);
            if(i<iMax && arrayB[j-1]>arrayA[i]){
                iMin = i+1;
            }else if(i>iMin && arrayA[i-1]>arrayB[j]){
                iMax = i-1;
            }else{
                int maxLeft = 0;
                if(i==0){
                    maxLeft = arrayB[j-1];
                }else if(j==0){
                    maxLeft = arrayA[i-1];
                }else{
                    maxLeft = Math.max(arrayA[i-1],arrayB[j-1]);
                }
                if((m+n)%2==1){
                    return maxLeft;
                }
                int minRight = 0;
                if(i==m){
                    minRight = arrayB[j];
                }else if(j==n){
                    minRight = arrayA[i];
                }else{
                    minRight = Math.min(arrayA[i],arrayB[j]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0;
    }
}
