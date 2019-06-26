package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-08
 */
public class LeetCode_509FibonacciNumber {
    public int fib(int N) {
        if(N == 0 || N == 1) return N;
        return fib(N - 1) + fib(N - 2);
    }

    public int fib2(int N) {
        if(N == 0 || N == 1) return N;
        int fibOne = 1;
        int fibTwo = 0;
        int fibN = 0;
        for (int i = 2; i <= N; i++) {
            fibN = fibOne + fibTwo;
            fibTwo = fibOne;
            fibOne = fibN;
        }
        return fibN;
    }


    // 公式矩阵
    private static final int[][] UNIT = {{1, 1}, {1, 0}};
    // 零矩阵
    private static final int[][] ZERO = {{0, 0}, {0, 0}};

    public int fib3(int N) {
        int[][] m = fb(N);
        return m[0][1];
    }
    /**
     * 利用二进制进行高效幂运算
     * 求斐波那契数列
     * */
    public static int[][] fb(int n) {
        if (n == 0) {
            return ZERO;
        }
        if (n == 1) {
            return UNIT;
        }
        if (n%2 == 0) {
            System.out.println(n >> 1);
            int[][] matrix = fb(n >> 1);

            return Multiply(matrix, matrix);
        } else {
            int[][] matrix = fb((n - 1) >> 1);
            return Multiply(Multiply(matrix, matrix), UNIT);
        }

    }

    /**
     * 矩阵乘法
     * */
    public static int[][] Multiply(int[][] m, int[][] n) {

        /**
         * 对于斐波那契数列来说，行和列都是2，这样写更易于理解，下面也给出了标准的矩阵乘法算法，是通用的
         * 用到此算法，除非进行算法学习和研究，否则一般都是进行较大数据的斐波那契求值，所以对结果取(10e9)+7的模
         * */
        int[][] r = new int[2][2];
        r[0][0] = (m[0][0]*n[0][0] + m[0][1]*n[1][0])%1000000007;
        r[0][1] = (m[0][0]*n[0][1] + m[0][1]*n[1][1])%1000000007;
        r[1][0] = (m[1][0]*n[0][0] + m[1][1]*n[1][0])%1000000007;
        r[1][1] = (m[1][0]*n[0][1] + m[1][1]*n[1][1])%1000000007;
        return r;
    }


}
