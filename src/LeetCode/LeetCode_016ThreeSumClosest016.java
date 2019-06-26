package LeetCode;

import java.util.Arrays;

/*给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).*/
public class LeetCode_016ThreeSumClosest016 {
    //2019年5月8日19:54:19
    /*
    * 我们要保证当前三数和跟给定值之间的差的绝对值最小，所以我们需要定义一个变量diff用来记录差的绝对值，然后我们还是要先将数组排个序，
    * 然后开始遍历数组，思路跟那道三数之和很相似，都是先确定一个数，然后用两个指针left和right来滑动寻找另外两个数，每确定两个数，
    * 我们求出此三数之和，然后算和给定值的差的绝对值存在newDiff中，然后和diff比较并更新diff和结果closest
    * */
    public int threeSumClosest(int[] nums, int target) {
        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(target - closest);
        Arrays.sort(nums);
        //三个数--> 所以 i < nums.length - 2
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                int newDiff = Math.abs(sum - target);
                if (diff > newDiff){
                    diff = newDiff;
                    closest = sum;
                }
                if (sum < target){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return closest;
    }
}
