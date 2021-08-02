//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 
// 👍 269 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int left = 0, right = 0;
    //找到频数最大的元素
    public int getDigit(int[] nums) {
        int digit = nums[0], maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j])
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                digit = nums[i];
            }
        }
        return digit;
    }
    //求取频数
    public int calcDegree(int[] nums) {
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j])
                    count++;
            }
            if (count > maxCount)
                maxCount = count;
        }
    }

    public int findShortestSubArray(int[] nums) {
        int maxDigit = getDigit(nums);
        for (int i = 0; i < nums.length; i++) {
            if (maxDigit == nums[i]) {
                left = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i++) {
            if(maxDigit == nums[i]) {
                right = i;
                break;
            }
        }


    }
}
//leetcode submit region end(Prohibit modification and deletion)
