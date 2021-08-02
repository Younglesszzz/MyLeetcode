//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 966 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        /**栈写法*/
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode p = new ListNode(-1);
        ListNode cur = head;
        //head指向此时的p结点(此时的p可认为有虚拟头结点的作用),函数返回head.next即可
        head = p;
        while (cur != null && cur.next != null) {
            //放入两个节点
            stack.add(cur);
            stack.add(cur.next);
            //当前向前走两步
            cur = cur.next.next;

            p.next = stack.pop();
            p = p.next;
        }
        //注意边界条件,当链表长度是奇数时，cur就不为空
        if (cur != null) {
            p.next = cur;
        } else {
            p.next = null;
        }
        return head.next;
        /**递归写法*/
        /*
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode a = p;
        ListNode b = p;
        ListNode t = p;
        while (b!=null && b.next!=null && b.next.next!=null) {
            //a前进一位，b前进两位
            a = a.next;
            b = b.next.next;
            //t指针用来处理边界条件
            t.next = b;
            a.next = b.next;
            b.next = a;
            //类比于while循环之前的三行代码，全体前进一位，即到目前a的位置
            a = a;//此句无意义，不用写
            t = a;
            b = a;
        }
        return p.next;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
