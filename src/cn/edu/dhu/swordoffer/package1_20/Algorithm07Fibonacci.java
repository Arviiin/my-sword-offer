package cn.edu.dhu.swordoffer.package1_20;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 * n<=39
 */
public class Algorithm07Fibonacci {
    public static int Fibonacci(int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        int a = 1;
        int b = 1;
        int temp = 0;
        while(n > 2){
            temp = a+b;
            a = b;
            b = temp;
            n -- ;
        }
        return temp;
    }
    public static void main(String [] args){
        int n =5;
        System.out.print(Fibonacci(n));
    }
}