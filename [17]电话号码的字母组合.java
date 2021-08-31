//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1461 👎 0


import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> res = new LinkedList<>();
    private StringBuilder sb = new StringBuilder();

    private void backtracking(String digits, int startIndex) {
        if (sb.length() == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String current = strings[digits.charAt(startIndex) - '0'];
        for (int i = 0; i < current.length(); i++) {
            sb.append(current.charAt(i));
            backtracking(digits, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }


    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return res;
        backtracking(digits, 0);
        return res;
    }


}
//leetcode submit region end(Prohibit modification and deletion)
