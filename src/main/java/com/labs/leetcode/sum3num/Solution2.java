package com.labs.leetcode.sum3num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/5/14
 */
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> re = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i=0;i<len-2;i++){

            if(i==0 || (i>0 && nums[i]!=nums[i-1])){
                int low = i+1;
                int height = len-1;
                int sum = 0 - (nums[i]);
                while (low<height){
                    if(nums[low]+nums[height]==sum){
                            re.add(Arrays.asList(nums[i],nums[low],nums[height]));
                            while (low < height && nums[low]==nums[low+1]){
                            low++;
                        }
                            while (low<height && nums[height]==nums[height-1]){
                            height--;
                        }
                        low --;
                        height --;
                    }else if(nums[low]+nums[height]<sum){
                        low ++;
                    }else{
                        height--;
                    }
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4};
        // int nums[] = {0, 0, 0};

        System.out.println(new Solution2().threeSum(nums));
    }
}
