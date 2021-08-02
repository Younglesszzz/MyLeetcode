//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 
//输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// k 的取值范围是 [1, 数组中不相同的元素的个数] 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的 
// 
//
// 
//
// 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。 
// Related Topics 数组 哈希表 分治 桶排序 计数 快速选择 排序 堆（优先队列） 
// 👍 812 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }


        Set<Map.Entry<Integer, Integer>> entries = hashMap.entrySet();

        //优先队列的本质就是堆，通过堆排序来维护数组中元素,本题中的堆是小顶堆，value值从小到大正序排列
      /*  PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });*/

        //lambda表达式写法
        PriorityQueue<Map.Entry<Integer, Integer>> queue =
                new PriorityQueue<>(((o1, o2) -> o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : entries) {
            queue.offer(entry);
            //依题意，所求是前k个高频元素，多余k个进行poll()操作，即去掉堆的根结点（最小的）
            if (queue.size() > k)
                queue.poll();
        }

        //生成结果
        for (int i = k - 1; i >= 0; i--) {
            res[i] = queue.poll().getKey();
        }

        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
