import java.util.Stack;

/**
 * @author zhangboqing
 * @date 2019-11-19
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 解题思路：通过栈
 */
public class Leetcode_20 {


    public boolean isValid(String s) {

        if (s == null || s.isEmpty()) {
            return true;
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) {
                stack.push(c);
                continue;
            }

            if (stack.empty()) {
                return false;
            }

            Character pop = stack.pop();
            if ('(' == pop && ')' == c) {
                continue;
            }
            if ('{' == pop && '}' == c) {
                continue;
            }
            if ('[' == pop && ']' == c) {
                continue;
            }
            return false;
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println((new Leetcode_20()).isValid("()"));
    }
}
