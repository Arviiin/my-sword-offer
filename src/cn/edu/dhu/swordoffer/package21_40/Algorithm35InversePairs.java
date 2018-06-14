package cn.edu.dhu.swordoffer.package21_40;
/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 输入描述:   题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 * 示例1
 * 输入
 * 1,2,3,4,5,6,7,0
 * 输出
 * 7
 */
public class Algorithm35InversePairs {
    public int InversePairs(int[] array) {
        //先判断数组为空或者没有元素则直接返回0
        if (array == null || array.length == 0) {
            return 0;
        }
        int[] copy = new int[array.length];//创建一个和原数组一样尺寸的数组
        /*for (int i = 0; i < array.length; i++) {//将数组复制一份，新数组名叫copy
            copy[i] = array[i];
        }*/


        int count = InversePairsCore(array, copy, 0, array.length - 1);//数值过大求余
        return count;
    }

    //先把数据分成前后两个数组(再把前面的数组一直递归直到分到每个数组仅有一个数据项,再把后面的数组一直递归直到分到每个数组仅有一个数据项)
    private int InversePairsCore(int[] array, int[] copy, int low, int high) {
        if (low == high) {//递归结束条件：即只有low和high指向同一个数组元素
            return 0;
        }
        int mid = (low + high) >> 1;//右移位除2
        int leftCount = InversePairsCore(array, copy, low, mid) % 1000000007;
        int rightCount = InversePairsCore(array, copy, mid + 1, high) % 1000000007;
        int count = 0;
        int i = mid;
        int j = high;
        int locCopy = high;
        while (i >= low && j > mid) {
            if (array[i] > array[j]) {
                count += j - mid;
                copy[locCopy--] = array[i--];
                if (count >= 1000000007)//数值过大求余
                {
                    count %= 1000000007;
                }
            } else {
                copy[locCopy--] = array[j--];
            }
        }
        for (; i >= low; i--) {
            copy[locCopy--] = array[i];
        }
        for (; j > mid; j--) {
            copy[locCopy--] = array[j];
        }
        for (int s = low; s <= high; s++) {
            array[s] = copy[s];
        }
        return (leftCount + rightCount + count) % 1000000007;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,2,3,4,5,6,7,0};
        /*int[] array = new int[]{364, 637, 341, 406, 747, 995, 234, 971, 571, 219, 993, 407,
                416, 366, 315, 301, 601, 650, 418, 355, 460, 505, 360, 965, 516, 648, 727, 667,
                465, 849, 455, 181, 486, 149, 588, 233, 144, 174, 557, 67, 746, 550, 474, 162, 268,
                142, 463, 221, 882, 576, 604, 739, 288, 569, 256, 936, 275, 401, 497, 82, 935, 983, 583,
                523, 697, 478, 147, 795, 380, 973, 958, 115, 773, 870, 259, 655, 446, 863, 735, 784, 3, 671,
                433, 630, 425, 930, 64, 266, 235, 187, 284, 665, 874, 80, 45, 848, 38, 811, 267, 575};//2519*/
        Algorithm35InversePairs a = new Algorithm35InversePairs();
        int result = a.InversePairs(array);
        System.out.println(result);
    }
}
//比较笨的解法
/* 判题目的告知运行超时
public int InversePairs(int [] array) {
    int p = 0;

    for (int i = 1; i < array.length; i++) {
        for (int j = 0; j < i; j++) {
            if (array[j] > array[i]){
                p++;
            }
        }
    }
    return p%1000000007;
}*/
