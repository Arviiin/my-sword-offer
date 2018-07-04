package cn.edu.dhu.swordoffer.package41_50;
/**
 *每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。HF作为牛客的资深元老,自然也准备了一些小游戏。
 *其中,有个游戏是这样的:首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 *每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 *从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 *并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class Algorithm46LastRemaining {

    //用数组来模拟环，思路还是比较简单，但是各种下标要理清
    public int LastRemaining_Solution(int n, int m) {//测试用例:5,2.对应输出应该为:2
        if (n == 0 || m == 0) return -1;//对传入参数进行判断
        int[] array = new int[n];//创建一个数组来模拟环,初始状态每个元素均为0,若出列唱完歌则将相应位置置为1
        int currentCirclePosition = -1,step = 0, count = n;//currentCirclePosition:即用来表示当前在环中的位置,step是用来统计是否报数到m了,到了要出列唱歌
                                                     //count用来计算当前还未出列唱歌的孩子
        while(count>0){   //跳出循环时将最后一个元素也设置为了-1
            currentCirclePosition++;
            if(currentCirclePosition >=n ) currentCirclePosition=0;  //模拟环。到达数组尾巴,归0,重头开始遍历
            if(array[currentCirclePosition] == -1) continue; //跳过被删除的对象。
            step++;                     //记录已走过的。
            if(step==m) {               //找到待删除的对象。
                array[currentCirclePosition]=-1;
                step = 0;
                count--;
            }        
        }
        /*    while(count>0)改成while(count>1)的时候可以这样写
        for (int i = 0; i < n ; i++) {
            if (array [i] == 0){
                return i;
            }
        }
        return -1;*/
        return currentCirclePosition;//返回跳出循环时的currentCirclePosition,即最后一个被设置为-1的元素
    }
    public static void main(String[] args) {
        Algorithm46LastRemaining obj = new Algorithm46LastRemaining();
        int result = obj.LastRemaining_Solution(5,2);
        System.out.println(result);
    }
}
