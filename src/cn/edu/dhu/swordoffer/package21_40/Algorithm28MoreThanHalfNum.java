package cn.edu.dhu.swordoffer.package21_40;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 *
 */
public class Algorithm28MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
//        int threshold = (int) Math.ceil(array.length/2.0);//Math.ceil(c)); Math.floor(c)  c为浮点数double
        int threshold = array.length/2;
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int count = 0;
            for (int j = i; j < array.length; j++) {
                if (array[j] == temp) {
                    count++;
                }
            }
            if (count > threshold) {
                return temp;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,2,2,2,5,4,2};
//        int[] array = new int[]{4,2,1,4,2,4};

        Algorithm28MoreThanHalfNum mainM = new Algorithm28MoreThanHalfNum();
        mainM.MoreThanHalfNum_Solution(array);
    }
}