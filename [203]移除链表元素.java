//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//
// Related Topics 链表

// 👍 544 👎 0
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
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public ListNode removeElements(ListNode head, int val) {
        /**
         * 既然要去除链表中的元素，那么应该创建一个节点来指向初始的head
         */

        /*//2021.7.12二刷
        ListNode start = new ListNode(0, head);//值为0的头结点
        ListNode p = start;//工作指针p，始终在head的前面一个位置

        while (head != null) {//从head开始检验值的正确性
            if (head.val == val) {
                p.next = head.next;
            } else {
                p = p.next;
            }
            head = head.next;
        }
        return start.next;*/


       /* ListNode start = new ListNode(0, head);
        ListNode p = start;

        while (head != null) {
            if (head.val == val) {
                p.next = head.next;
            } else {
                p = head;   //保证p始终是head.prev，不可以使用p.next,否则会让p与head指向同一个节点
            }
            head = head.next;
        }
        return start.next;*/
    }
}
//leetcode submit region end(Prohibit modification and deletion)
