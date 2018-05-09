package cn.edu.dhu.test;
import java.util.ArrayList;
import java.util.Stack;
public class Solution {
    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA.length == 0 || popA.length == 0)
            return false;
        Stack<Integer> s = new Stack<Integer>();
        //用于标识弹出序列的位置
        int popIndex = 0;
        for(int i = 0; i< pushA.length;i++){
            s.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while(!s.empty() &&s.peek() == popA[popIndex]){
                //出栈
                s.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        int [] a = new int[]{1,2,3,4,5};
        int [] b = new int[]{4,3,5,2,1};
        boolean isPopOrder = IsPopOrder(a, b);
        System.out.println(isPopOrder);

    }

}