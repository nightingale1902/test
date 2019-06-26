package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/*给定一个未排序的整数数组，找出其中没有出现的最小的正整数。*/
public class LeetCode_041FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && (!list.contains(nums[i]))){
                list.add(nums[i]);
            }
        }
        if (list.size() == 0) return 1;

        for (int i = 1; i <= list.size(); i++) {
            if (list.get(i-1) > i && ( !list.contains(i) ) ){
                return i;
            }
        }
        return list.get(list.size() - 1) + 1;
    }


}
