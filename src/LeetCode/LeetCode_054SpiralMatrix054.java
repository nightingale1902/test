package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_054SpiralMatrix054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) return new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int up = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (true){
            //横向
            for (int i = left; i <= right ; i++)
                res.add(matrix[up][i]);
            if (++up > bottom) break;

            //竖向
            for (int i = up; i <= bottom ; i++) {
                res.add(matrix[i][right]);
            }
            if (--right < left) break;

            //横反向
            for (int i = right; i >= left ; i--) {
                res.add(matrix[bottom][i]);
            }
            if (--bottom < up) break;

            //竖反向
            for (int i = bottom; i >= up ; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }

}
