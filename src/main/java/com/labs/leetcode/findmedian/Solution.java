package com.labs.leetcode.findmedian;
//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
// nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] arrayA, int[] arrayB) {
        int m = arrayA.length;
        int n = arrayB.length;
        int halfLen = (m + n + 1) / 2;
        //交换数组
        if(m > n){
            int temp[] = arrayA;
            arrayA = arrayB;
            arrayB = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int iMin=0;
        int iMax=m;
        while (iMin<=iMax){
            int i = (iMin+iMax)/2;
            int j = halfLen - i;
            System.out.println("iMin="+iMin+" iMax="+iMax+" i="+i+" j="+j);
            if(i < iMax && arrayB[j-1]>arrayA[i]){
                iMin = i + 1;
            }else if(i>iMin && arrayA[i-1]>arrayB[j]){
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

                if((m+n)%2 ==1 ){
                   return maxLeft;
                }

                int minRight = 0;
                if(i==m){
                    minRight = arrayB[j];
                }else if(j==n){
                    minRight = arrayA[i];
                }else{
                    minRight = Math.min(arrayB[j],arrayA[i]);
                }
                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0d;
    }

    public static void main(String[] args) {
        /*int[] arrayA = {32,35,37,41,43};
        int[] arrayB = {4,6,8,11,15,16,20,25,26,31,32,36,40,42,45};*/
        int[] arrayA = {31,33,36,41,42};//{23,25,27,41,42};
        int[] arrayB = {12,15,18,19,21,24,25,28,32,37,43,51,54,62};
        System.out.println(new Solution().findMedianSortedArrays(arrayA,arrayB));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
