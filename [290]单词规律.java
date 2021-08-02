//给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 示例1: 
//
// 输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 示例 4: 
//
// 输入: pattern = "abba", str = "dog dog dog dog"
//输出: false 
//
// 说明: 
//你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。 
// Related Topics 哈希表 
// 👍 309 👎 0



//leetcode submit region begin(Prohibit modification and deletion)
import java.util.HashMap;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        /** 单map加if解法：
        * 先判断hashmap中是否存在key，如果不存在，put(key,value)
        * 如果存在，判断当前value是否与get到的value相同，如果不同，返回false */

        HashMap<Character, String> map = new HashMap<>();
        String[] strings = s.split(" ");
        if (pattern.length() != strings.length)
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            //如果不存在此key的情况
            if (!map.containsKey(pattern.charAt(i))) {
                //要存入的value和已经存在的value重复
                if (map.containsValue(strings[i]))
                    return false;
                map.put(pattern.charAt(i), strings[i]);
            }
            //存在此key的情况
            else
                if (!strings[i].equals(map.get(pattern.charAt(i))))
                    return false;
        }
        return true;

        /**双map双射解法（思想优美）:
         * char对应唯一String,同理String只能对应唯一char */
        HashMap<Character, String> c2s = new HashMap<>();
        HashMap<String, Character> s2c = new HashMap<>();

        String[] strings = s.split(" ");
        if(pattern.length() != strings.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            //先判断,后put
            if (c2s.containsKey(pattern.charAt(i)) && !c2s.get(pattern.charAt(i)).equals(strings[i]))
                    return false;
            else
                c2s.put(pattern.charAt(i), strings[i]);

            if (s2c.containsKey(strings[i]) && s2c.get(strings[i]) != pattern.charAt(i))
                    return false;
            else
                s2c.put(strings[i], pattern.charAt(i));
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
