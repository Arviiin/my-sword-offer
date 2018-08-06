package cn.edu.dhu.leetcode;
public class CountPrimes {
    /**
     * 计算素数
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 1) return 0;
        // 默认所有的元素值都会设置为false
        boolean[] notPrime = new boolean[n];
        notPrime[0] = true;
        notPrime[1] = true;
        //这里使用i*i   避免重复调用费时的函数Sqt（）
        for (int i = 2; i * i < n; i++) {
            // 如果i是一个质数，i将i的倍数设置为非质数
            // 如是i是一个合数，则它必定已经设置为true了，因为是从2开始处理的
            if (!notPrime[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        // 统计质数的个数
        int result = 0;
        for (boolean b : notPrime) {
            if (!b) {
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountPrimes obj = new CountPrimes();
        int result = obj.countPrimes(40);
        System.out.println(result);
    }
}
