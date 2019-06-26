package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-08
 */
public class LeetCode_338CountingBits338 {
    public int[] countBits(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num ; i++) {
            res[i] = countBitsHelper(i);
        }
        return res;

    }
    //一个整数的二进制中1的个数
    public int countBitsHelper(int num){
        int count = 0;
        int flag = 1; //移动flag去和num比较
        while (flag != 0){
            if ((num & flag) != 0){
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public int countBitsHelper2(int num){
        int count = 0;
        while (num != 0){
            ++ count;
            num = (num - 1) & num;
        }
        return count;

    }

}
