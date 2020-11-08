package week06;

import java.util.Stack;

/**
 * @program: test
 * @description: 最长有效括号
 * @author: ChenWeiJun
 * @create: 2020-11-08 19:24
 **/
public class LongestValidParentheses {

    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int length = 0;
        int left = -1;
        for (int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if (c == '(') stack.push(i);
            else {
                if (stack.isEmpty()) left = i;
                else {
                    stack.pop();
                    length = Math.max(length,i- (stack.isEmpty()? left: stack.peek()));
                }
            }
        }
        return length;
    }
}
