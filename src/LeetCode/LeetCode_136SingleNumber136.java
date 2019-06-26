package LeetCode;

import java.util.Arrays;

/**
 * @Author: YourName
 * @Date: 2019-06-18
 */
public class LeetCode_136SingleNumber136 {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

}
