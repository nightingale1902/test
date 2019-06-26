package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
/*给定一个可包含重复数字的序列，返回所有不重复的全排列。*/
public class LeetCode_047PermutationsII047 {
    public List<List<Integer>> permuteUnique(int[] nums){
        LinkedList<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        if (nums == null || nums.length == 0) return res;
        permutationsHelper(res, new LinkedList<>(), nums, new boolean[nums.length]);
        return res;
    }
    public void permutationsHelper(List<List<Integer>> res, List<Integer> curList, int[] nums, boolean[] used){
        if (curList.size() == nums.length){
            res.add(new LinkedList<>(curList));
        } else {
            int preNum = nums[0] - 1;
            for (int i = 0; i < nums.length; i++) {
                if (!used[i] && (nums[i] != preNum)){
                    preNum = nums[i];
                    curList.add(nums[i]);
                    used[i] = true;
                    permutationsHelper(res, curList, nums, used);
                    used[i] = false;
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
}
