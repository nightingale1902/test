package LeetCode;

public class LeetCode_055JumpGame {
    /*从后往前遍历数组，如果遇到的元素可以到达最后一行，则截断后边的元素。否则继续往前，若最后剩下的元素大于1个，则可以判断为假。否则就是真，时间复杂度O(n)就可以。*/
    public boolean canJump(int[] nums) {
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n){
                n = 1;
            }else {
                n++;
            }
            if (i == 0 && n > 1){
                return false;
            }
        }
        return true;
    }
}
