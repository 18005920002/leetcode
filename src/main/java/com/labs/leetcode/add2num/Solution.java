package com.labs.leetcode.add2num;
//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
// 示例：
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
// Related Topics 链表 数学


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int bitSum = l1.val + l2.val;
        int carry = bitSum/10;
        ListNode head = new ListNode(bitSum%10);
        ListNode current = head;
        while (l1.next!=null || l2.next!=null){
            int v1 = null==l1.next?0:l1.next.val;
            int v2 = null==l2.next?0:l2.next.val;
            bitSum = v1+v2+carry;
            current.next = new ListNode(bitSum%10);
            carry = bitSum / 10;
            current = current.next;
            if(null!=l1.next){
                l1 = l1.next;
            }
            if(null!=l2.next){
                l2 = l2.next;
            }
        }
        if(carry>0){
            current.next = new ListNode(carry);
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(1);
        l2.next.next = new ListNode(9);

        ListNode re = new Solution().addTwoNumbers(l1,l2);
        System.out.println(re.val+"->"
                +re.next.val+"->"
                +re.next.next.val+"->"
                +re.next.next.next.val+"->");
    }
}
//leetcode submit region end(Prohibit modification and deletion)
