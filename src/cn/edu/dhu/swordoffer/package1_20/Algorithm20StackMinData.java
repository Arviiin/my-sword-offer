package cn.edu.dhu.swordoffer.package1_20;
/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
import java.util.Stack;
public class Algorithm20StackMinData {
    Stack<Integer> dataStack = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        dataStack.pop();
        minStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}