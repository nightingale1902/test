package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-24
 */
public class LeetCode_167TwoSumIIInputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0)
            return null;
        int[] res = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int temp = numbers[left] + numbers[right];
            if (temp == target) {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            } else if (temp < target) {
                left++;
            }else
                right--;
        }
        return res;
    }

}
