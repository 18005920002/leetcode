package com.labs.leetcode.sum2num;

import java.util.HashMap;
import java.util.Map;

//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
public class Solution {
    /**
     * 两遍Hash
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int cmp =target - nums[i];
            if(map.containsKey(cmp) && i!=map.get(cmp)){
                return new int[]{i,map.get(cmp)};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] re = new Solution().twoSum(new int[]{2,7,6,8,11},15);
        System.out.println(re[0]+":"+re[1]);
    }
}
