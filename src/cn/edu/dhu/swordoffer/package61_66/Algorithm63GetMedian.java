package cn.edu.dhu.swordoffer.package61_66;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * Java的PriorityQueue 是从JDK1.5开始提供的新的数据结构接口，默认内部是自然排序，结果为小顶堆，也可以自定义排序器，比如下面反转比较，完成大顶堆。
 * 思路：
 * 为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
 * 1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
 * 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
 *
 *
 * 其实就是将数据流分成了两个部分，从中间切分（想象一下数据流有序时的样子），
 * 大根堆里面是小的一半，小根堆大的一半，当求中位数时只用关心中间的一个数或者两个数，这时关心的数就是堆顶的数
 *
 * 其实也就是在进去的时候,做了划分,第一个数为奇数位进大根堆(注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最小元素进入大根堆),
 * 第二个数为偶数位进小跟堆,以此类推,那么取的时候,若总的位数为奇数时，大顶堆堆顶就是中位数,和进去顺序一致
 */
public class Algorithm63GetMedian {

    int count = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {//这里未指定第一个参数,则取默认值11
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {

        count++;
        //if ((count & 1) == 0) { // 判断偶数的高效写法
        if (count %2 == 0) {//当数据总数为偶数时，新加入的元素，应当进入小根堆
                //（注意不是直接进入小根堆，而是经大根堆筛选后取大根堆中最大元素进入小根堆）
                //1.新加入的元素先入到大根堆，由大根堆筛选出堆中最大的元素
                maxHeap.offer(num);
                int filteredMaxNum = maxHeap.poll();
                //2.筛选后的【大根堆中的最大元素】进入小根堆
                minHeap.offer(filteredMaxNum);
        } else {//当数据总数为奇数时，新加入的元素，应当进入大根堆
                //（注意不是直接进入大根堆，而是经小根堆筛选后取小根堆中最小元素进入大根堆）
                //1.新加入的元素先入到小根堆，由小根堆筛选出堆中最小的元素
                minHeap.offer(num);
                int filteredMinNum = minHeap.poll();
                //2.筛选后的【小根堆中的最小元素】进入大根堆
                maxHeap.offer(filteredMinNum);
        }
    }

    public Double GetMedian() {
        if (count == 0)
            throw new RuntimeException("no available number!");
        double result;
        //总数为奇数时，大顶堆堆顶就是中位数
        if ((count & 1) == 1)
            result = maxHeap.peek();
        else
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        return result;
    }

    public static void main(String[] args) {
        Algorithm63GetMedian obj = new Algorithm63GetMedian();
        int[] data = {5, 2, 3, 4, 1, 6, 7, 0, 8};
        for (int i = 0; i < data.length; i++) {
            obj.Insert(data[i]);
        }
        Double resule = obj.GetMedian();
        System.out.println(resule);
    }

}