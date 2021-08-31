//给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。 
//
// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层
//为第 h 层，则该层包含 1~ 2h 个节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,2,3,4,5,6]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目范围是[0, 5 * 104] 
// 0 <= Node.val <= 5 * 104 
// 题目数据保证输入的树是 完全二叉树 
// 
//
// 
//
// 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？ 
// Related Topics 树 深度优先搜索 二分查找 二叉树 
// 👍 512 👎 0


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
import java.util.LinkedList;
import java.util.Queue;
import java.util.UnknownFormatConversionException;
class Solution {
    //普通二叉树递归求法
    public int countNodes1(TreeNode root) {
        if (root == null)
            return 0;
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        int totalNum = 1 + leftNum + rightNum;
        return totalNum;
    }

    //层序遍历求法
    public int countNodes2(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode front = queue.poll();
                count++;

                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
            }
        }
        return count;
    }

    //利用完全二叉树性质的递归，递归寻找是满二叉树的子树
    public int countNodes(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = 0;
        int rightHeight = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;

        while (left != null) {
            left = left.left;
            leftHeight++;
        }
        while (right != null) {
            right = right.right;
            rightHeight++;
        }

        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
