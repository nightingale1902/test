package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-16
 */
public class LeetCode_085MaximalRectangle {
    //将每层都构成直方图，然后利用84的代码。
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        if(matrix.length<=0){
            return 0;
        }
        int[] height=new int[matrix[0].length]; //面积 = height * (right - left)
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {//将每一层构成直方图
                height[j] = matrix[i][j] == '0' ? 0 : (1 + height[j]);
            }
            res = Math.max(res, func(height,0,height.length - 1));
        }
        return res;
    }
    private int func(int[] heights, int left, int right) {
        if (left > right) {
            return 0;
        }

        if (left == right) {
            return heights[left];
        }

        int minIndex = left;
        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = left + 1; i <= right; i++) {
            if (isDescending && heights[i - 1] < heights[i]) {
                isDescending = false;
            } else if (isAscending && heights[i - 1] > heights[i]) {
                isAscending = false;
            }

            if (heights[minIndex] > heights[i]) {
                minIndex = i;
            }
        }

        int max = Integer.MIN_VALUE;
        if (isAscending) {
            for (int i = left; i <= right; i++) {
                max = Math.max(max, (right - i + 1) * heights[i]);
            }
        } else if (isDescending) {
            for (int i = right; i >= left; i--) {
                max = Math.max(max, (i - left + 1) * heights[i]);
            }
        } else {
            max = Math.max(max, (right - left + 1) * heights[minIndex]);
            max = Math.max(max, func(heights, left, minIndex - 1));
            max = Math.max(max, func(heights, minIndex + 1, right));
        }
        return max;
    }
}
