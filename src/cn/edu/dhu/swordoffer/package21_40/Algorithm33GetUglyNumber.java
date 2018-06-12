package cn.edu.dhu.swordoffer.package21_40;

import java.util.ArrayList;

/**
 *把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 题目很难懂，感觉表述不清，这里8=2*2*2 因子应该指的是质因子     求按从小到大的顺序输出第N个丑数
 *
 * 该思路： 我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
 */
/*
说下思路，如果p是丑数，那么p=2^x * 3^y * 5^z
那么只要赋予x,y,z不同的值就能得到不同的丑数。
如果要顺序找出丑数，要知道下面几个特点。
对于任何丑数p：
（一）那么2*p,3*p,5*p都是丑数，并且2*p<3*p<5*p
（二）如果p<q, 那么2*p<2*q,3*p<3*q,5*p<5*q
现在说说算法思想：
    由于1是最小的丑数，那么从1开始，把2*1，3*1，5*1，进行比较，得出最小的就是1
的下一个丑数，也就是2*1，
    这个时候，多了一个丑数‘2’，也就又多了3个可以比较的丑数，2*2，3*2，5*2，
这个时候就把之前‘1’生成的丑数和‘2’生成的丑数加进来也就是
(3*1,5*1,2*2，3*2，5*2)进行比较，找出最小的。。。。如此循环下去就会发现，
每次选进来一个丑数，该丑数又会生成3个新的丑数进行比较。
    上面的暴力方法也应该能解决，但是如果在面试官用这种方法，估计面试官只会摇头吧
。下面说一个O（n）的算法。
    在上面的特点中，既然有p<q, 那么2*p<2*q(竖着看下面)
                1*2 1*3 1*5
                2*2 2*3 2*5
                3*2 3*3 3*5
那么“我”在前面比你小的数都没被选上，你后面生成新的丑数一定比“我”大吧，那么你乘2，或者3，或者5
生成的丑数一定比我乘2或3或5生成的丑数大吧，那么在我选上之后你才有机会选上。
这样其实每次我们只用比较3个数：用于乘2的最小的数、用于乘3的最小的数，用于乘5的最小的
数。也就是比较(2*x , 3*y, 5*z) ，x>=y>=z的，

找出最小值之后的替换 是指之前顺序排列的丑数数组的每个值（！）都要乘以2,3,5的比较，
一开始1*2和1*3和1*5 比较，找出最小的是2，把2放进a数组，这时候替换2的数就是2*2,；
比较2*2,1*3,1*5，找到最小的是3，把3放进a数组，替换3的是2*3；比较2*2,2*3,1*5，找到最小是4,4放进a数组，
这时候替换的用来乘以2的数就是3即3*2。
重点说说下面代码中p的作用：int p[] = new int[] { 0, 0, 0 }; p[0]表示最小用于
乘2比较数在数组a中的【位置】。
*/
public class Algorithm33GetUglyNumber {
    public int GetUglyNumber_Solution(int index) {

        if(index<=0)return 0;
        ArrayList<Integer> list=new ArrayList<Integer>();
        list.add(1);
        int i2=0,i3=0,i5=0;
        while(list.size()<index)//循环的条件
        {
            int m2=list.get(i2)*2;
            int m3=list.get(i3)*3;
            int m5=list.get(i5)*5;
            int min=Math.min(m2,Math.min(m3,m5));
            list.add(min);
            if(min==m2)i2++;
            if(min==m3)i3++;
            if(min==m5)i5++;
        }
        return list.get(list.size()-1);
    }
    public static void main(String[] args) {
        Algorithm33GetUglyNumber a = new Algorithm33GetUglyNumber();
        int uglyNumber = a.GetUglyNumber_Solution(8);
        System.out.println(uglyNumber);
    }
}

