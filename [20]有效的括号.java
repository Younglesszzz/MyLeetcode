//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2174 👎 0


import sun.awt.image.ImageWatched;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (c == '(') deque.push(')');
            else if (c == '{') deque.push('}');
            else if (c == '[') deque.push(']');
            else if (deque.isEmpty() || deque.peek() != c) return false;
            else deque.pop();
        }
        return deque.isEmpty();

        /**
         * 有史以来最笨的写法/(ㄒoㄒ)/
         */
//        Stack<Character> stack = new Stack<>();
//        if (s.length() % 2 != 0)
//            return false;
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            char pop;
//            if (ch == '(' || ch == '{' || ch == '[')
//                stack.push(ch);
//            else {
//                if (stack.isEmpty())
//                    return false;
//                else {
//                    pop = stack.pop();
//                    if (!((pop == '(' && ch == ')') || (pop == '[' && ch == ']') || (pop == '{' && ch == '}')))
//                        return false;
//                }
//            }
//        }
//        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
