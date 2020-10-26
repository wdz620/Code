package LeetCode.Char;

import java.util.*;

/**
 * @Author: Wdz
 * @Date 2020/8/18 20:07
 * @Description: 20. 有效的括号 TODO
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 输入: "()"
 * 输出: true
 * 输入: "([)]"
 * 输出: false
 *
 * empty() 测试堆栈是否为空。
 * peek() 查看堆栈顶部的对象，但不从堆栈中移除它。
 * pop() 移除堆栈顶部的对象
 * push() 压入堆栈顶部。
 */
public class IsValid {
    public static void main(String[] args) {
        String s = "{(]}";
        System.out.println(isValid0(s));

    }
    //栈的思想
    public static boolean isValid1(String s)
    {
        if(s.length() %2 != 0) //先行判断剔除
            return false;

        Stack<Character> stack = new Stack<>(); //创建 stack 对象

        for(int i=0; i<s.length();i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')    // 入栈
                stack.push(c);
            else
            {
                if(stack.isEmpty())     //针对首先出现的右侧符号进行判断
                    return false;

                char top = stack.pop();     // 出栈

                if(c == ')' && top != '(') //对应匹配
                    return false;
                if(c == ']' && top != '[')
                    return false;
                if(c == '}' && top != '{')
                    return false;
            }
        }
        return stack.isEmpty(); //检查栈是否为空
    }


    //第一反应：利用栈的思想
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};

        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }

    //网上参考：
    private static final Map<Character, Character> map = new HashMap<Character, Character>() {{
        put('{', '}');
        put('[', ']');
        put('(', ')');
        put('?', '?');
    }};

    public static boolean isValid0(String s) {
        if (s.length() > 0 && !map.containsKey(s.charAt(0))) return false;
        LinkedList<Character> stack = new LinkedList<Character>() {{
            add('?');
        }};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) stack.addLast(c);
            else if (map.get(stack.removeLast()) != c) return false;
        }
        return stack.size() == 1;
    }
}
