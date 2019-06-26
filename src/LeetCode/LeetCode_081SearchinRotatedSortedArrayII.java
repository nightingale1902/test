package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-15
 */
public class LeetCode_081SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        return searchHelper(nums, target, 0, nums.length - 1);
    }

    public boolean searchHelper(int[] nums, int target, int l, int r) {
        if (l > r) return false;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) return true;
            if (nums[mid] > nums[l]){ //左边升序
                if (target >= nums[l] && target <= nums[mid]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }else if (nums[mid] < nums[l]){
                if (target >= nums[mid] && target <= nums[r]){
                    l = mid;
                }else {
                    r = mid - 1;
                }
            }else
                l += 1;
        }
        return false;
    }
}
