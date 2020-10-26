package Offer.Stack;

import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/10/14 10:04
 * @Description: 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class IsPopOrder {
    public static void main(String[] args) {
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        int[] popB = {4, 3, 5, 1, 2};
        System.out.println(isPopOrder1(pushA, popA));
        System.out.println(isPopOrder2(pushA, popA));
        System.out.println();
        System.out.println(isPopOrder1(pushA, popB));
        System.out.println(isPopOrder2(pushA, popB));
    }

    //参考一
    public static boolean isPopOrder1(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        //外循环将第一个数组压栈
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            //如果栈顶元素和第二个数组相等，就将该元素弹出，判断第二个数组的下一个元素
            while (!stack.isEmpty() && popA[idx] == stack.peek()) {
                stack.pop();
                idx++;
            }
        }
        return stack.isEmpty();
    }

    //参考二
    public static boolean isPopOrder2(int [] pushA,int [] popA) {
        if(pushA == null || popA == null) return false;
        Stack<Integer> stack = new Stack<>();
        int p = 0;
        int pLength = pushA.length;
        for(int i = 0;i<popA.length;i++){
            if(!stack.isEmpty() && stack.peek() == popA[i]){
                stack.pop();
            }else{
                while(p<pLength && pushA[p] != popA[i]){
                    stack.push(pushA[p]);
                    p++;
                }
                p++;
            }
        }
        return stack.isEmpty();
    }

}
