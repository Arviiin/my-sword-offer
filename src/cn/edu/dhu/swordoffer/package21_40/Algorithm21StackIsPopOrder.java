package cn.edu.dhu.swordoffer.package21_40;
/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 */

import cn.edu.dhu.datastruct.ListNode;

import java.util.ArrayList;
import java.util.Stack;

import static cn.edu.dhu.datastruct.ListNode.GenNodeList;

public class Algorithm21StackIsPopOrder {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int length = pushA.length;
        int jCount = -1;
        for (int i = 0; i <length; i++) {
            for (int j = jCount+1; j < length; j++) {
                if(stack.empty()){
                    jCount++;
                    if (popA[i] != pushA[j]) {
                        stack.push(pushA[j]);
                    }else {
                        break;
                    }
                }else {
                    int temp = stack.peek();
                    if(temp == popA[i]){
                        stack.pop();
                        break;
                    }else {
                        if (popA[i] != pushA[j]) {
                            stack.push(pushA[j]);
                        }else {
                            break;
                        }
                    }
                }
            }
        }
        if(stack.empty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int [] a = new int[]{1,2,3,4,5};
        int [] b = new int[]{4,5,3,2,1};
        boolean isPopOrder = IsPopOrder(a, b);
        System.out.println(isPopOrder);

    }
}