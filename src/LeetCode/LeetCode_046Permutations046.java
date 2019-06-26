package LeetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
//给定一个没有重复数字的序列，返回其所有可能的全排列
public class LeetCode_046Permutations046 {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (nums == null || nums.length == 0) return res;
        permutationsHelper(res, new LinkedList<>(), nums, new HashSet<>());
        return res;
    }
    public void permutationsHelper(List<List<Integer>> res, List<Integer> curList, int[] nums, HashSet<Integer> set){
        if (curList.size() == nums.length) res.add(new LinkedList<>(curList));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (!set.contains(nums[i])){
                    curList.add(nums[i]);
                    int last = curList.size() - 1;
                    set.add(nums[i]);
                    permutationsHelper(res, curList, nums, set);
                    set.remove(nums[i]);
                    curList.remove(last);
                }
            }
        }
    }

}
