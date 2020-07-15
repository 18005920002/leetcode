package com.labs.leetcode.stack.validbracket;

import java.util.Stack;

/**
 * @Description:
 * @Author: tanyun.zheng
 * @Date: 2020/5/18
 */
public class Solution {
    public static void main(String[] args) {
        String s = "{[()]}(){}]";
        System.out.println(new Solution().isValid(s));
    }
    public boolean isValid(String s){
        char[] left = {'{','[','('};
        char[] right = {'}',']',')'};
        char[] cs = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i=0;i<cs.length;i++){
            //左括号入栈
            if(cs[i]==left[0]||cs[i]==left[1]||cs[i]==left[2]){
                stack.push(cs[i]);
            }else {
                if(stack.isEmpty()){
                    //右括号且空栈，直接返回
                    return false;
                }
                //如果当前是右括号，并且==栈顶
                if(cs[i]==right[0] && left[0]==stack.peek().charValue()){
                    stack.pop();
                } else if(cs[i]==right[1] && left[1]==stack.peek().charValue()){
                    stack.pop();
                } else if(cs[i]==right[2] && left[2]==stack.peek().charValue()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
