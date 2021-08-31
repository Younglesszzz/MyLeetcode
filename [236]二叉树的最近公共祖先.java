//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 1246 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res = null;
    //采用后序遍历，由下到上
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root, p, q);
        return res;
    }

    //后序遍历
    public boolean traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;

        boolean lson = traversal(root.left, p, q);//左
        boolean rson = traversal(root.right, p, q);//右

        //中
        boolean flag = false;
        if (root.val == p.val) flag = true;//此结点是一个儿子，下面有没有儿子不一定，如果有，前面res = root会执行，但是递归仍然会继续，到根节点才会停止
        if (root.val == q.val) flag = true;//同
        if (lson == true || rson == true) flag = true;//在当前结点下面存在儿子

        if (lson && rson) res = root;//两个儿子都在下面
        if ((root.val == p.val || root.val == q.val) && (lson || rson)) res = root;//另一个儿子恰好在此结点下面，此节点也是一个儿子，根据规定这个儿子就是祖先

        return flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
