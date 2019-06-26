package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-16
 */
public class LeetCode_069SqrtX {
    public int mySqrt(int x) {
        long t = x;
        //https://blog.csdn.net/ztsinghua/article/details/47722645
        t = 0x5f3759df - (t >> 1);
        while (!(t * t <= x && (t + 1)*(t + 1) > x))
            t = (x / t + t) / 2;
        return (int)t;
    }
}
