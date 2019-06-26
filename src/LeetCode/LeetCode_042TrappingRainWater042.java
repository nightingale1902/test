package LeetCode;

import java.util.Stack;

public class LeetCode_042TrappingRainWater042 {
    /*1. 找出最高点
      2. 分别从两边往最高点遍历：如果下一个数比当前数小，说明可以接到水
     */
    public int trap(int[] height) {
        if (height == null || height.length <= 1) return 0;
        int max_height = 0;
        int max_height_index = 0;
        //找最高点
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (h > max_height){
                max_height = h;
                max_height_index = i;
            }
        }

        //从左往最高点遍历
        int area = 0;
        int tmp = height[0];
        for (int i = 0; i < max_height_index; i++) {
            if (height[i] > tmp){
                tmp = height[i];
            }else {
                area = area + (tmp - height[i]);
            }
            
        }

        //从右往最高点遍历
        int temp = height[height.length - 1];
        for (int i = height.length - 1; i >= max_height_index; i--) {
            if (height[i] > temp){
                temp = height[i];
            }else {
                area = area + (temp - height[i]);
            }
        }

        return area;
    }

    public int trap2(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, n = height.length, res = 0;
        while (i < n){
            if (stack.isEmpty() || height[i] <= height[stack.peek()]){
                stack.push(i++);
            }else {
                int temp = stack.pop();
                if (stack.isEmpty()) continue;
                res += (Math.min(height[i], height[stack.peek()]) - height[temp]) * (i - stack.peek() - 1);
            }
        }
        return res;
    }
}
