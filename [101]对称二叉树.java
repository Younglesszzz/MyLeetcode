//给定一个二叉树，检查它是否是镜像对称的。 
//
// 
//
// 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 
//
//     1
//   / \
//  2   2
// / \ / \
//3  4 4  3
// 
//
// 
//
// 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的: 
//
//     1
//   / \
//  2   2
//   \   \
//   3    3
// 
//
// 
//
// 进阶： 
//
// 你可以运用递归和迭代两种方法解决这个问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 1267 👎 0


//leetcode submit region begin(Prohibit modification and deletion)


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) return true;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode node1, TreeNode node2) {
        //先处理
        if (node1 == null && node2 != null) return false;
        else if (node1 != null && node2 == null) return false;
        else if (node1 == null && node2 == null) return true;
        else if (node1.val != node2.val) return false;

        //此时为节点不为空且数值相等的情况
        boolean outside = compare(node1.left, node2.right);// 左子树：左、 右子树：右
        boolean inside = compare(node1.right, node2.left);// 左子树：右、 右子树：左
        boolean isSame = outside & inside;// 左子树：中、 右子树：中 （逻辑处理）

        return isSame;
    }


    /**
     * 队列迭代法
     * @思路 把左右两个子树要比较的元素顺序放入一个容器，成对的取出来比较
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            //先处理null的情况
            if (leftNode == null && rightNode == null)
                continue;

            if ((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null))
                return false;

            if (leftNode.val != rightNode.val)
                return false;

            //不为null且对称
            //outside
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            //inside
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        //把symmetric2中的队列换成栈，一样成立，不做赘述
        //细心的话，其实可以发现，这个迭代法，其实是把左右两个子树要比较的元素顺序放进一个容器，然后成对成对的取出来进行比较，那么其实使用栈也是可以的。
        //只要把队列原封不动的改成栈就可以了，我下面也给出了代码
        if (root == null) return true;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()) {
            TreeNode rightNode = stack.pop();
            TreeNode leftNode = stack.pop();

            //先处理null的情况
            if (leftNode == null && rightNode == null)
                continue;

            if ((leftNode == null && rightNode != null) || (leftNode != null && rightNode == null))
                return false;

            if (leftNode.val != rightNode.val)
                return false;

            stack.push(rightNode.left);
            stack.push(leftNode.right);
            stack.push(rightNode.right);
            stack.push(leftNode.left);
        }

        return true;
    }

 }
//leetcode submit region end(Prohibit modification and deletion)
