//编写一个算法来判断一个数 n 是不是快乐数。 
//
// 「快乐数」定义为： 
//
// 
// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。 
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。 
// 如果 可以变为 1，那么这个数就是快乐数。 
// 
//
// 如果 n 是快乐数就返回 true ；不是，则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：19
//输出：true
//解释：
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 哈希表 数学 
// 👍 536 👎 0


import java.util.HashSet;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hashSet = new HashSet<>();

        while (n != 1 && !hashSet.contains(n)) {
            hashSet.add(n);
            n = getNext(n);
        }

        return n == 1;

    }

    public int getNext(int n) {
        int res = 0;
        while (n > 0) {
            int temp = n % 10;
            n = n / 10;
            res += temp * temp;
        }
        return res;
    }

    /*public int calcSum(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            n /= 10;
            sum += digit * digit;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        *//*while (true) {
            set.add(n);
            n = calcSum(n);
            if (n == 1)
                return true;
            if(set.contains(n))
                return false;
        }*//*

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = calcSum(n);
        }
        return n == 1;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
