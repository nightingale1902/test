package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-08
 */
public class LeetCode_153FindMinimuminRotatedSortedArray153 {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return 0;
        int low = 0, high = len - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[high]){
                low = mid + 1;
            }else if(nums[mid] == nums[high]){
                high = high - 1;
            }else{
                high = mid;
            }
        }
        return nums[low];

    }
}
