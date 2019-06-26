package LeetCode;

public class LeetCode_059SpiralMatrixII059 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 1) {
            matrix[0][0] = 1;
        }
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int count = 1;
        while (true){
            //横向
            for (int i = left; i <= right ; i++) {
                matrix[up][i] = count++;
            }
            if (++up > down) break;

            //竖向
            for (int i = up; i <= down ; i++) {
                matrix[i][right] = count++;
            }
            if (--right < left) break;

            //横反向
            for (int i = right; i >= left ; i--) {
                matrix[down][i] = count++;
            }
            if (--down < up) break;

            //竖反向
            for (int i = down; i >= up ; i--) {
                matrix[i][left] = count++;
            }
            if (++left > right) break;

        }
        return matrix;

    }

}
