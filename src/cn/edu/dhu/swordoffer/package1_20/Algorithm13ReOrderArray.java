package cn.edu.dhu.swordoffer.package1_20;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * <p>
 * 泛型只能代表引用类型，不能是原始类型，原始类型有byte/short/int/long 浮点型：float.double 字符型char 布尔型：boolean,
 * 引用类型与原始类型的区别在于虽然二者保存在栈中，但原始类型保存的是实际值，而引用类型保存的是一个对象的内存地址
 */

/**
 * 泛型只能代表引用类型，不能是原始类型，原始类型有byte/short/int/long 浮点型：float.double 字符型char 布尔型：boolean,
 * 引用类型与原始类型的区别在于虽然二者保存在栈中，但原始类型保存的是实际值，而引用类型保存的是一个对象的内存地址
 */

/**
 * 思路以空间换时间，
 * 先从前往后遍历一遍把奇数存到List中，再从后往前遍历，遇到偶数将其移动最后一个位置上，然后倒数第二个位置。。。
 * 从前往后遍历List将其插入数组
 */
public class Algorithm13ReOrderArray {
    public static void reOrderArray(int[] array) {
        //ArrayList<int> arrayList = new ArrayList<int>();//不能是原始类型会报错
        List<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                arrayList.add(array[i]);
            }
        }
        int p = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] % 2 == 0) {
                array[p] = array[i];
                p--;
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        for (int arr : array
                ) {

            System.out.print(arr);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 4, 6, 1, 3, 5, 7};
        reOrderArray(a);
    }
}