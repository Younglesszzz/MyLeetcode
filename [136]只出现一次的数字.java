//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1703 👎 0


import java.util.HashSet;
import java.util.Hashtable;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int singleNumber(int[] nums) {
        /*HashSet<Integer> set = new HashSet<>();
        for (int i : set) {
            if (set.contains(i)) {
                set.remove(i);
                continue;
            }
            set.add(i);
        }
        return set.iterator().next();*/
        Hashtable<Integer, Integer> table = new Hashtable<>();
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
            }
            table.put(nums[i], count);
        }

        for (int i = 0; i < nums.length; i++) {
            if (table.get(nums[i]) == 1) {
                res = nums[i];
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
