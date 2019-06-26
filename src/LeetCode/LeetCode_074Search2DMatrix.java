package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-16
 */
public class LeetCode_074Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return false;
        int column = matrix[0].length - 1; //列
        int row = 0;                       //行
        while(row < matrix.length && column >= 0){
            if(matrix[row][column] < target)
                row++;
            else if(matrix[row][column] > target)
                column--;
            else
                return true;
        }
        return false;
    }
}
