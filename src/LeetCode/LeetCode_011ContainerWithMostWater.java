package LeetCode;

public class LeetCode_011ContainerWithMostWater {
    public int maxArea(int[] height) {
        //time:O(n) space:O(1)
        //不能倾斜容器，且 n 的值至少为 2。
        if (height.length < 2) return 0;
        int res = 0;
        int l = 0, r = height.length - 1;
        while (l < r){
            res = Math.max(res, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }

        }
        return res;
    }
}
