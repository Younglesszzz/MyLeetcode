//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 105] 内 
// -1000 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 463 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.LinkedList;
import java.util.Queue;

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
class Solution {
    //递归法
    public int minDepth1(TreeNode root) {
       if (root == null) return 0;

       int leftside = minDepth(root.left);//左
       int rightside = minDepth(root.right);//右

        //中
       //需要判断子树是否为空
        int depth;
        if (root.left == null && root.right != null)
           depth = 1 + rightside;
        else if (root.left != null && root.right == null)
           depth = 1 + leftside;
        else//else中情况包括两边都是null和两边不为null的情况，都可以直接取最小值
           depth =  1 + Math.min(leftside, rightside);


        return depth;
    }

    //迭代法
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            depth++;//记录当前层数（深度）
            for (int i = 0; i < levelSize; i++) {
                TreeNode front = queue.poll();
                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
                //如果front就是叶子，直接返回当前层数
                if (front.left == null && front.right == null)
                    return depth;
            }
        }
        return depth;
    }
//leetcode submit region end(Prohibit modification and deletion)
