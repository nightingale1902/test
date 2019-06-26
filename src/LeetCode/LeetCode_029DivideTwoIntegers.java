package LeetCode;
/*给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
返回被除数 dividend 除以除数 divisor 得到的商*/
public class LeetCode_029DivideTwoIntegers {
    //Bit Operation
    /*
    * 1. + -
    * 2. 越界
    * 3. = 0
    * 4. 正常
    *
    * time:O(logn)
    * space:O(logn)
    * */
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) sign = -1;
        long ldivided = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        if (ldivided < ldivisor || ldivided == 0) return 0;
        long lres = divide(ldivided, ldivisor);
        int res;
        if (lres > Integer.MAX_VALUE){
            res = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }else res = (int) (sign * lres);
        return res;
    }
    public static long divide(long ldivided, long ldivisor){
        if (ldivided < ldivisor) return 0;
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) <= ldivided){
            sum += sum;
            multiple += multiple;//倍数
        }
        return multiple + divide(ldivided - sum, ldivisor);
    }
}
