//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表 
// 👍 341 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * 解题关键：统计字符出现的次数*/
class Solution {
    public boolean isAnagram(String s, String t) {
        /**
         * 方法：数组作为简单HashMap
         * 思路：遇到s串中的字母累加次数，t串递减次数，检查数组元素是否为0
         * 效率：	执行耗时:1 ms,击败了100.00% 的Java用户
         * 			内存消耗:38.5 MB,击败了78.07% 的Java用户
         */

        /*int[] record = new int[26];2
        for (char c : s.toCharArray()) {
            record[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            record[c - 'a']--;
        }

        for (int i : record) {
            if (i != 0)
                return false;
        }

        return true;*/

        /**
         * 方法：Java自带HashMap
         * 效率：	执行耗时:16 ms,击败了23.24% 的Java用户
         * 			内存消耗:39.3 MB,击败了11.33% 的Java用户
         */
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
            if (map.get(t.charAt(i)) < 0)
                return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
