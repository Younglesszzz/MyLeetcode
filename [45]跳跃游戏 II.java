//给你一个非负整数数组 nums ，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 假设你总是可以到达数组的最后一个位置。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 104 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 贪心 数组 动态规划 
// 👍 1139 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int curDistance = 0;
        int nextDistance = 0;
        int res = 0;
        for (int i = 0; i < nums.length && i <= curDistance; i++) {//此题保证了一定可以到达终点，而且每次到达加油站（其实就是55题的cover处)都会进行检查，如果一定要用i <= cover的条件，需要在循环里用if保证i不会数组越界,或者用&&短路
            nextDistance = Math.max(i + nums[i], nextDistance);
            if (i == curDistance) {//到达加油站，加油
                if (curDistance < nums.length - 1) {//这个加油站不是终点站
                    curDistance = nextDistance;
                    res++;
//                    if (nextDistance >= nums.length - 1) break;//加上这条语句可以提前判断是否还需要再进入循环，减少耗时
                } else {//这个加油站恰好是终点站
                    break;
                }
            }
        }
        return res;
    }

    public int jump(int[] nums) {
        int res = 0;
        int curDistance = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length - 1; i++) {//只让i走到length - 2的位置
            nextDistance = Math.max(nextDistance, nums[i] + i);
            if (i == curDistance) {//因为一定能到终点，那么只统计中间的加油站就可以了
                curDistance = nextDistance;
                ans++;
            }
        }
        return ans;
    }
//leetcode submit region end(Prohibit modification and deletion)
