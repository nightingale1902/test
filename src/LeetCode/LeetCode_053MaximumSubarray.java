package LeetCode;

public class LeetCode_053MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for(int num : nums){
            /*假设sum<=0，那么后面的子序列肯定不包含目前的子序列，所以令sum = num；如果sum > 0对于后面的子序列是有好处的。res = Math.max(res, sum)保证可以找到最大的子序和*/
            if (sum > 0){
                sum += num;
            }else {
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}
