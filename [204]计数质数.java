//统计所有小于非负整数 n 的质数的数量。 
//
// 
//
// 示例 1： 
//
// 输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 106 
// 
// Related Topics 哈希表 数学 
// 👍 632 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPrime(int n) {
        if (n == 0 || n == 1)
            return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if(isPrime(i))
                count++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
