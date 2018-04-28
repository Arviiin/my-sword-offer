package cn.edu.dhu.swordoffer;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * //return Math.pow(base ,exponent);//终极解法
 */

/**
  * 1.全面考察指数的正负、底数是否为零等情况。
  * 2.写出指数的二进制表达，例如13表达为二进制1101。
  * 3.举例:10^13 = 10^1101 = 10^0001*10^0100*10^1000。
  * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
  */
/**快速幂要不要了解一下
    原理
            把b转换成2进制数
            该2进制数第i位的权为（2^(i-1)）
            例如
            a^11=a^(2^0+2^1+2^3)
            11的二进制是1 0 1 1
            11 = 2^3*1 + 2^2*0 + 2^1*1 + 2^0*1
            因此，我们将a^11转化为算a^(2^0)*a^(2^1)*a^(2^3)*/

/**
 * 快速幂可以用位运算这个强大的工具实现
 * b & 1 //也就是取b的二进制最末位
 * b >> 1 //就是去掉b的二进制最末位
 */

public class Algorithm12Power {
    public static double Power(double base, int n) {

        double res = 1;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        } else {// n==0
            return 1;// 0的0次方
        }
        while (exponent != 0) {        //记住在计算机里都是二进制表示可以直接进行位运算
            if ((exponent & 1) == 1)   //指数的二进制表示末位是1,当末尾是0时则不将其算进结果，继续翻倍。
                res *= base;           //比如11的二进制是1 0 1 1   即：11 = 2^3*1 + 2^2*0 + 2^1*1 + 2^0*1
            base *= base;// 翻倍
            exponent >>= 1;// 右移一位
        }
        return n >= 0 ? res : (1 / res);
    }

    public static void main(String[] args) {
        System.out.println(Power(2, 11));
    }
}
