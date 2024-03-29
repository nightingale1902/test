package LeetCode;

public class LeetCode_033SearchinRotatedSortedArray033 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){ //保证不会出现end + 1 = start的情况
            int mid = start + (end - start) / 2; //避免overflow
            if (nums[mid] == target) return mid;
            if (nums[start] < nums[mid]){
                if (nums[start] <= target && target <= nums[mid]) end = mid;
                else start = mid;
            }else if (nums[mid] < nums[end]){
                if (nums[mid] <= target && target <= nums[end]) start = mid;
                else end = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
}
