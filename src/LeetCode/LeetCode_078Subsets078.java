package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）*/
public class LeetCode_078Subsets078 {
    /*递归的解法，相当于一种深度优先搜索，参见网友JustDoIt的博客，由于原集合每一个数字只有两种状态，要么存在，要么不存在，
    那么在构造子集时就有选择和不选择两种情况，所以可以构造一棵二叉树，左子树表示选择该层处理的节点，右子树表示不选择，
    最终的叶节点就是所有子集合*/
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        helper(result, new ArrayList<>(), nums, 0);
        return result;

    }
    public void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        res.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(res, list, nums, i + 1);
            list.remove(list.size() - 1);

        }
    }

}
