package cn.edu.dhu.swordoffer.package21_40;
/**
 *题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algorithm27Permutation {


    public void PermutationHelper(char[] chars, int i, List<String> list) {
        if (i == chars.length - 1) {
            String val = String.valueOf(chars);
            if (!list.contains(val))
                list.add(val);
        } else {
            for (int j = i; j < chars.length; j++) {
                swap(chars, i, j);
                PermutationHelper(chars, i+1, list);
                swap(chars, i, j);
            }
        }
    }
 
    public void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public ArrayList<String> Permutation(String str) {

        List<String> res = new ArrayList<>();//父类引用指向子类对象，向上转型
        if (str != null && str.length() > 0) {
            char[] chars = str.toCharArray();
            PermutationHelper(chars, 0, res);
            Collections.sort(res);//将最后得到的字符串中字符的所有排列，进行字典序排序
        }
        return (ArrayList)res;//向下转型
    }

    public static void main(String[] args) {
        Algorithm27Permutation p = new Algorithm27Permutation();//为了能够在静态方法中调用非静态方法Permutation()
        System.out.println(p.Permutation("bca").toString());
    }
}