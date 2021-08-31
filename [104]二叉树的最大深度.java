//给定一个二叉树，找出其最大深度。 
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例： 
//给定二叉树 [3,9,20,null,null,15,7]， 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
//
// 返回它的最大深度 3 。 
// Related Topics 树 深度优先搜索 递归 
// 👍 810 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
import java.util.Deque;
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
    int res = 0;
    //后序遍历
    public int maxDepth1(TreeNode root) {
        if (root == null)
            return 0;
        int leftside = maxDepth(root.left);//左
        int rightside = maxDepth(root.right);//右
        //最后取左右深度最大的数值 再+1 （加1是因为算上当前中间节点）就是目前节点为根节点的树的深度。
        int depth = Integer.max(leftside, rightside) + 1;//中
        return depth;
    }

    //后序遍历优化版
    public int maxDepth11(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = 0;
        int rightDepth = 0;
        //加if语句可以避免不必要的递归，减少内存消耗
        if(root.left != null)
            leftDepth = maxDepth(root.left);
        if(root.right != null)
            rightDepth = maxDepth(root.right);
        int totalDepth = 1 + Math.max(leftDepth, rightDepth);

        return totalDepth;
    }

    //前序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return res;
        getDepth(root, 1);
        return res;
    }

    void getDepth(TreeNode node, int depth) {
        res = depth > res ? depth : res;//中
        if (node.left != null) {//左
            depth++;//深度+1
            getDepth(node.left, depth);
            depth--;//回溯，深度减一
//            getDepth(node.left, depth + 1);
        }
        if (node.right != null) {//右
            depth++;//深度+1
            getDepth(node.right, depth);
            depth--;//回溯，深度减一
//            getDepth(node.right, depth + 1);
        }
        return;
    }

    //层序遍历
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            //记录当前层数
            depth++;
            for (int i = 0; i < levelSize; i++) {
                TreeNode front = queue.poll();
                if (front.left != null)
                    queue.offer(front.left);
                if (front.right != null)
                    queue.offer(front.right);
            }
        }
        return depth;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
