package cn.edu.dhu.swordoffer.package41_50;

import java.util.ArrayList;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 */
public class Algorithm43LeftRotateString {

    public String LeftRotateString(String str, int n) {


        //思路,先补成两个字符串长度,再截取
        int len = str.length();
        if (len == 0) return "";
        n = n % len;
        str += str;
        return str.substring(n, len + n);

        /*//保证旋转的位数大于字符串的长度，否则返回空字符串
        if(n>str.length())
            return "";
        //把原字符串截取成俩字符串，然后拼接
        String s1 = str.substring(0, n);
        String s2 = str.substring(n,str.length());
        return s2 + s1;*/
        /*方法一:
        if (str.length() < n){
            return "";
        }
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = n; i < chars.length; i++) {
            sb.append(chars[i]);
        }
        for (int i = 0; i < n; i++) {
            sb.append(chars[i]);
        }
        return sb.toString();*/
    }

    public static void main(String[] args) {
        String string = "abcXYZdef";
        Algorithm43LeftRotateString obj = new Algorithm43LeftRotateString();
        String result = obj.LeftRotateString(string, 3);
        System.out.println(result);
    }
}
