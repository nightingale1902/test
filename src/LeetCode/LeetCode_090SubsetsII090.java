package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-15
 */
public class LeetCode_090SubsetsII090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupHelper(result, new ArrayList<>(), nums, 0);
        result.add(new ArrayList<>());
        return result;

    }
    public void subsetsWithDupHelper(List<List<Integer>> result, List<Integer> cur, int[] nums, int index){
        if (index == nums.length) return;
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            cur.add(nums[i]);
            result.add(new ArrayList<>(cur));
            subsetsWithDupHelper(result, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
