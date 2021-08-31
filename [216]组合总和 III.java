//找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。 
//
// 说明： 
//
// 
// 所有数字都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: k = 3, n = 7
//输出: [[1,2,4]]
// 
//
// 示例 2: 
//
// 输入: k = 3, n = 9
//输出: [[1,2,6], [1,3,5], [2,3,4]]
// 
// Related Topics 数组 回溯 
// 👍 337 👎 0


import java.util.ArrayList;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    private void backtracking(int k, int n, int sum, int startIndex) {
        if (sum == n && path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (sum >= n) {
            return;
        }

//        if (path.size() == k) {
//            if (sum == n) res.add(new ...);
//            return;
//        }
//        if (sum > n) {
//            return;
//        }

        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtracking(k, n, sum, i + 1);
            path.removeLast();
            sum -= i;
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
