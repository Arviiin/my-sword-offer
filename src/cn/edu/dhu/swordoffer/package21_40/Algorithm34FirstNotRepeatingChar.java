package cn.edu.dhu.swordoffer.package21_40;

import java.util.HashMap;

/**
 *在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
//思路，创建一个hashmap，将字符串里的字符作为key，出现的次数作为value，第一次放进去的时候，value赋值为1，后面判断
    //若不是第一次放进去，即map中已经有此字符，则将当前字符对应的value取出，再+1放进去，最后遍历字符串，当其value为1时，则返回。
public class Algorithm34FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))){
                int count = hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i),++count);//注意必须是++count，若换成count++则不行。
            }else {
                hashMap.put(str.charAt(i),1);
            }
        }

        int pos =-1;
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.get(str.charAt(i)) == 1){
                return i;
            }
        }
        return pos;
    }
    public static void main(String[] args) {
        Algorithm34FirstNotRepeatingChar a = new Algorithm34FirstNotRepeatingChar();
        int uglyNumber = a.FirstNotRepeatingChar("google");
        System.out.println(uglyNumber);
    }
}
//比较笨的解法
/*public int FirstNotRepeatingChar(String str) {
    char[] chars = str.toCharArray();
    int returnInt =-1;
    for (int i = 0; i < chars.length; i++) {
        int flag = 0;
        for (int j = 0; j < chars.length; j++) {
            if (i != j){
                if (chars[i] == chars[j]){
                    flag = 1;
                    break;
                }
            }

        }
        if (flag == 0){
            returnInt = i;
            break;
        }
    }
    return returnInt;
}*/
