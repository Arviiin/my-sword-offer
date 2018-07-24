package cn.edu.dhu.swordoffer.package61_66;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}，
 * {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */
public class Algorithm64MaxInWindows {//deque 双端队列容器 ( double-ended queue )

    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || size <= 0 || num.length < size)
            return res;
        //创建优先级队列，是队头存放队列中的最大值，方便记录
        PriorityQueue<Integer> queue = new PriorityQueue<>(size, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int count = 0;            //入队列计数变量
        for (int i = 0; i < num.length - size + 1; i++) {
            while (count < size) {
                queue.add(num[i + count]);
                count++;
            }
            int maxNum = queue.peek();
            res.add(maxNum);
            //重置count和优先级队列
            count = 0;
            queue.clear();
        }
        return res;
        /*一般想法
        ArrayList<Integer> arrayList = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) {
            return arrayList;
        }
        for (int i = 0; i < num.length-size+1; i++) {
            int max = num[i];
            for (int j = i; j <= i+size-1; j++) {
                if (num[j] > max){
                    max = num[j];
                }
            }
            arrayList.add(max);
        }
        return arrayList;*/
    }

    public static void main(String[] args) {
        Algorithm64MaxInWindows obj = new Algorithm64MaxInWindows();
        int[] data = new int[]{2, 3, 4, 2, 6, 2, 5, 1};
        ArrayList<Integer> result = obj.maxInWindows(data, 3);
        System.out.println(result);
    }
}