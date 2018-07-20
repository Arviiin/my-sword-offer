package cn.edu.dhu.swordoffer.package51_60;

import java.util.ArrayList;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Algorithm51Multiply {

    //思路:求B[i]时候,把对应位置的数组A的元素赋值为1,把整个数组进行相乘,其结果即为所求.记得赋值为1乘完后,恢复原来的数组.
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            B[i] = 1;
            int temp = A[i];
            A[i] = 1;
            for (int j = 0; j < A.length; j++) {
                B[i] = B[i] * A[j];
            }
            A[i] = temp;
        }
        return B;
    }

    public static void main(String[] args) {
//        int[] data = new int[]{1,2,3,4,5};//测试用例:  [1,2,3,4,5]   对应输出应该为:  [120,60,40,30,24]
        int[] data = new int[]{1, 2, 0, 4, 5};//测试用例:  [1,2,0,4,5]   对应输出应该为:  [0,0,40,0,0]
        Algorithm51Multiply obj = new Algorithm51Multiply();
        int[] result = obj.multiply(data);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);

        }
    }
}



    /*public int StrToInt(String str) {
        if ("".equals(str.trim()))
            return 0;
        int flag = 1;
        if (str.startsWith("-")){
            flag = -1;
        }
        String substring = "";
        if (str.startsWith("+") || str.startsWith("-")){
            substring = str.substring(1);
        }else {
            substring = str;
        }

        char[] strChars = substring.toCharArray();
        int length = strChars.length;
        int result = 0;
        int temp = -1;
        for (int i = 0; i < length && temp != -11; i++) {
            switch(strChars[i]){
                case '0':
                    //;
                    temp = 0;
                    break;
                case '1':
                    //...;
                    temp = 1;
                    break;
                case '2':
                    //
                    temp = 2;
                    break;
                case '3':
                    //...;
                    temp = 3;
                    break;
                case '4':
                    //;
                    temp = 4;
                    break;
                case '5':
                    //...;
                    temp = 5;
                    break;
                case '6':
                    //;
                    temp = 6;
                    break;
                case '7':
                    //...;
                    temp = 7;
                    break;
                case '8':
                    //;
                    temp = 8;
                    break;
                case '9':
                    //...;
                    temp = 9;
                    break;
                default:
                    //...;
                    temp = -11;
                    break;
            }
            int currentResult = (int) (temp * (Math.pow(10,length -1 -i)));
            result += currentResult;
        }
        if (temp == -11){
            return 0;
        }
        return flag*result;
    }*/
