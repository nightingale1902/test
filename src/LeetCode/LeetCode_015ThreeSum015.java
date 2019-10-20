package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得
 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
    注意：答案中不可以包含重复的三元组。
    例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
    满足要求的三元组集合为：
    [
        [-1, 0, 1],
        [-1, -1, 2]
    ]
*/
public class LeetCode_015ThreeSum015 {
    //2019年4月28日21:44:17
    //很重要，借鉴twosum，
    //time: O(n^2) space: O(n);
    public List<List<Integer>> threeSum(int[] nums) {
		        List<List<Integer>> res = new ArrayList<>();
		        if (nums == null || nums.length < 3) return res;  // 鲁棒性检查
		        Arrays.sort(nums);
		        for (int i = 0; i < nums.length - 2; i++) {
			        //跳过重复,去除重复答案
			        if (i > 0 && nums[i] == nums[i - 1]) continue;
			        int low = i + 1, high = nums.length - 1, sum = 0 - nums[i];
			        //从这开始类似twosum
			        while (low < high) {
				        if (nums[low] + nums[high] == sum) {
					        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
					        //去重
					        while (low < high && nums[low] == nums[low + 1]) low++;
					        while (low < high && nums[high] == nums[high - 1]) high--;
					        low++;
					        high--;
				        } else if (nums[low] + nums[high] < sum) {
					        low++;
				        } else high--;
			        }
        }
        return res;
    }
}
