package LeetCode;

public class LeetCode_031NextPermutation031 {
    /* step1: 1 2^ 7 4 3 1
       step2: 1 2^ 7 4 3^ 1
       step3: 1 3^ 7 4 2^ 1
       step4: 1 3  1^ 2^ 4^ 7^
     */
    //time O(n), space O(1)
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int firstSmall = -1;
        //step1
        for (int i = nums.length - 2; i >= 0 ; i--) {
            if (nums[i] < nums[i + 1]){
                firstSmall = i;
                break;
            }
        }
        //nums元素为逆序
        if (firstSmall == -1){
            reverse(nums, 0, nums.length - 1);
            return;
        }
        //step2
        int firstLarge = -1;
        for (int i = nums.length - 1; i > firstSmall; i--) {
            if (nums[i] > nums[firstSmall]){
                firstLarge = i;
                break;
            }
        }
        //step3
        swap(nums, firstSmall, firstLarge);

        //step4
        reverse(nums, firstSmall + 1, nums.length - 1);
        return;
    }
    public void reverse(int[] nums, int i, int j){
        if (nums == null || nums.length == 0) return;
        while (i < j){
            swap(nums, i++, j--);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i++] = nums[j];
        nums[j--] = temp;
    }

}
