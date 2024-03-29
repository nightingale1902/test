package LeetCode;
public class LeetCode_035SearchInsertPosition035 {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return mid;
            else if (target < nums[mid]) end = mid;
            else start = mid;
        }
        if (target <= nums[start]){
            return start;
        }else if (target <= nums[end]){
            return end;
        }else {
            return end + 1;
        }
    }

}
