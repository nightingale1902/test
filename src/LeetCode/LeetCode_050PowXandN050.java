package LeetCode;

public class LeetCode_050PowXandN050 {
    public double myPow(double x, int n) {
        if (x <= -100 || x >= 100) return Double.parseDouble(null);
        if (n < (-2^31) || n > (2^31 - 1)) return Double.parseDouble(null);
        if (x == 0) return 0;
        if (n == 0) return 1;
        return Math.pow(x, n);
    }

    public double myPow2(double num, int power) {
         if (power == 0 || num == 1) return 1;
         if (power == 1) return num;
         if (power < 0)
             //-(power + 1) 去避免MIN_VALUE --> Integer.MIN_VALUE加“-”号，其值仍然为MIN_VALUE
             /*
             *  System.out.println(Integer.MIN_VALUE);  ----> -2147483648
                System.out.println(-(Integer.MIN_VALUE)); ----> -2147483648
                System.out.println(-(Integer.MIN_VALUE + 1)); ----> 2147483647 --> 所以要在前面补回一个num，即乘以一个num
                */
             return 1 / (num * myPow2(num, -(power + 1)));
         double res = 1;
         while (power > 1){
             if (power % 2 == 1){
                 res *= num;
             }
    /*         if ((power & 0x1) == 1){
                 res *= num;
             }*/
             num = num * num;
             power /= 2;
         }
         res *= num;
         return res;
    }


    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }
    public double myPow3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

}
