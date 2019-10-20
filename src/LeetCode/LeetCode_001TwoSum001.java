package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_001TwoSum001 {
	public int[] twoSum(int[] nums, int target) {
		//2. handle corner cases
		if (nums == null || nums.length < 2) {
			return new int[2];
		}
		//1. define return value
		int[] res = new int[2];
		//<Integer, Integer> 分别是key为数组的值，value为所求的数组的index
		//3. value <-> index map
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums.length; ++i) {
			if (m.containsKey(target - nums[i])) {
				res[0] = m.get(target - nums[i]);
				res[1] = i;
				break;
			}
			m.put(nums[i], i);
		}
		return res;
	}

}
