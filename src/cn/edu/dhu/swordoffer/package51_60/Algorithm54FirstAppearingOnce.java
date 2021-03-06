package cn.edu.dhu.swordoffer.package51_60;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，
 * 当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
//使用一个HashMap来统计字符出现的次数，同时用一个ArrayList来记录输入流，
// 每次返回第一个出现一次的字符都是在这个ArrayList（输入流）中的字符作为key去map中查找。
public class Algorithm54FirstAppearingOnce {
    HashMap<Character, Integer> map = new HashMap<>();
    ArrayList<Character> list = new ArrayList<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        char c = '#';
        for (char key : list) {
            if (map.get(key) == 1) {
                c = key;
                break;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        Algorithm54FirstAppearingOnce obj = new Algorithm54FirstAppearingOnce();
        char[] chars = "google".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            obj.Insert(chars[i]);
        }
        char result = obj.FirstAppearingOnce();
        System.out.println(result);
    }
}