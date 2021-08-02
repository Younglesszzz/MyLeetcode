//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3533 👎 0


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //包含List的List
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        //最左侧i，左侧left，右侧left
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {//如果排序玩
                return result;
            }
            //错误去重方式：if(nums[i] == nums[i+1]) { continue; } 会把-1, -1, 2这种情况漏掉
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int right = nums.length - 1;
            int left = i + 1;
            //内循环
            while (right > left) {
               int sum = nums[i] + nums[left] + nums[right];
               if (sum > 0) {
                   right--;
               } else if (sum < 0) {
                   left++;
               } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重操作，不可以在result add结果之前进行去重操作,否则可能错判0, 0, 0这种情况
                   while (right > left && nums[right] == nums[right - 1]) right--;
                   while (right > left && nums[left] == nums[left + 1]) left++;
                    //找到答案时，双指针同时收缩（因为已经去重了，且left与right加入过result一次，需要进行下一轮判断了）
                   right--;
                   left++;
               }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
