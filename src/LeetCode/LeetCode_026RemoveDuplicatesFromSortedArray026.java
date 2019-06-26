package LeetCode;
/*给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成*/
public class LeetCode_026RemoveDuplicatesFromSortedArray026 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int i = 0, j = 0;
        int length = nums.length;
        while (j < length){
            while (j + 1 < length && nums[j] == nums[j + 1]) ++j;
            nums[i++] = nums[j++];
        }
        return i;

    }

}
