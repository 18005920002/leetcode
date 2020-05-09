package com.labs.leetcode.findmedian;

/**
 * @Description: 找两个有序数组的中位数
 * @Author: tanyun.zheng
 * @Date: 2020/5/9
 */
public class Solution3 {

    /*public static void main(String[] args) {
        int[] arrayA = {1,2};
        int[] arrayB = {3,4};
        System.out.println(new Solution2().findMedianSortedArrays(arrayA,arrayB));
    }*/

    public double findMedianSortedArrays(int[] arrayA, int[] arrayB) {
        int m = arrayA.length;
        int n = arrayB.length;
        //交换两个数组
        if (m > n) {
            int temp[] = arrayA;
            arrayA = arrayB;
            arrayB = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        //数组半长
        int halfLen = (m + n + 1) / 2;
        //搜素区间
        int iMin = 0, iMax = m;
        while (iMin <= iMax){
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            System.out.println("iMin="+iMin+" iMax="+iMax+" i="+i+" j="+j);
            if(i < iMax && arrayB[j-1]>arrayA[i]){
                iMin = i + 1;
            }else if(i > iMin && arrayA[i-1]>arrayB[j]){
                iMax = i - 1;
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
                int minRight=0;
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
        return 0.0;
    }

    public static void main(String[] args) {
        /*int[] arrayA = {32,35,37,41,43};
        int[] arrayB = {4,6,8,11,15,16,20,25,26,31,32,36,40,42,45};*/
        int[] arrayA = {31,33,36,41,42};//{23,25,27,41,42};
        int[] arrayB = {12,15,18,19,21,24,25,28,32,37,43,51,54,62};
        System.out.println(new Solution3().findMedianSortedArrays(arrayA,arrayB));
    }
}
