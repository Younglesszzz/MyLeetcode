//根据一棵树的中序遍历与后序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
// Related Topics 树 数组 哈希表 分治 二叉树 
// 👍 544 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
    //依题意，假设树中没有重复的元素
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return traversal(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode traversal(int[] inorder, int inLeft, int inRight,
                              int[] postorder, int postLeft, int postRight) {
        // 1.是否为空或叶子
        if (inRight - inLeft < 1) {
            return null;
        }
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        // 2.取后序数组最后一个元素为根节点
        TreeNode root = new TreeNode(postorder[postRight - 1]);


        // 3.定位根节点在中序数组中的位置
        int cutIndex = 0;
        for (int i = 0; i < inRight; i++) {
            if (inorder[i] == root.val) {
                cutIndex = i;
            }
        }

        // 4.递归左右子树
        // 中序数组去除inorder[cutIndex],后序数组去除postorde[postRight -1]
        root.left = traversal(inorder, inLeft, cutIndex,
                postorder, postLeft, postLeft + (cutIndex - inLeft));
        root.right = traversal(inorder, cutIndex + 1, inRight,
                postorder, postLeft + (cutIndex - inLeft), postRight - 1);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
