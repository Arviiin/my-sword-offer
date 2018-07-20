package cn.edu.dhu.swordoffer.package41_50;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 * 输出
 * 2147483647
 * 0
 */
public class Algorithm49StrToInt {
    //思路,既然不能用字符串转整数,那么想到用ascii码相减的方式获取数值
    public int StrToInt(String str) {
        if ("".equals(str.trim()))
            return 0;
        int flag = 1;
        if (str.startsWith("-")) {
            flag = -1;
        }
        String substring;
        if (str.startsWith("+") || str.startsWith("-")) {
            substring = str.substring(1);
        } else {
            substring = str;
        }

        char[] strChars = substring.toCharArray();
        int length = strChars.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (strChars[i] < 48 || strChars[i] > 57)
                return 0;
            result = result * 10 + strChars[i] - 48;
        }
        return flag * result;
    }

    public static void main(String[] args) {
        Algorithm49StrToInt obj = new Algorithm49StrToInt();
        int result = obj.StrToInt("-2147483648");
        System.out.println(result);
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
