package Offer.Stack;

import java.util.Stack;

/**
 * @Author: Wdz
 * @Date 2020/7/21 8:35
 * @Description:两个栈实现队列 TODO
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 本题的基本意图是：用两个后入先出的栈来实现先入先出的队列。对于这个问题，我们可以通过一个实例来进行具体分析。不
 * 难得出相应的规律：有两个栈stack1和stack2，每次向队列中插入元素可以都压入到stack1中，当需要从队列中删除元素时，
 * 我们应该是删除最早插入的那个（FIFO），这时可以将stack1中的元素逐个弹出并压入stack2，直到stack1为空，这时最早插入的元素就位于stack2的栈顶，可以直接弹出。
 *
 *   因此，我们总结如下：压入元素时，都压入栈1，当需要弹出时，从栈2弹出，当栈2不为空时直接弹出栈顶元素，为空时将栈1的元素“倒进去”。
 */
public class Stack_Queue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
