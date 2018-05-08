package cn.edu.dhu.swordoffer.package1_20;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Algorithm05 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
        return;
    }

    public int pop() {//当s2中元素全部出栈前（即s2不空时），不能再向s2中push元素。
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
            return stack2.pop();
        }
    }
}