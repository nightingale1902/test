package LeetCode;

import java.util.Arrays;

/**
 * @Author: YourName
 * @Date: 2019-06-24
 */
public class LeetCode_169MajorityElement169 {
    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0)
            return -1;
        Arrays.sort(nums);
        int count = 1;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (res == nums[i])
                count++;
            else {
                count--;
                if (count == 0)
                    res = nums[i + 1];
            }
        }
        return res;
    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
