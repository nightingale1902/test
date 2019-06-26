package LeetCode;

public class LeetCode_037SudokuSolver037 {
    //重要 --> 回溯法
    public void solveSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) return;
        boolean tmp = solveSudokuHelper(board, 0, 0);

    }
    public boolean solveSudokuHelper(char[][] board, int row, int col){
        if (board == null || board.length != 9 || board[0].length != 9) return false;
        //从当前位置找到第一个'.'的位置
        while (row < 9 && col < 9){
            if (board[row][col] == '.') break;//find the empty cell
            if (col == 8){  //col 0-->8
                col = 0;
                row++;
            }else col++;
        }

        if (row >= 9) return true; //check out bound after getting location
        //下一个要计算的位置
        int newRow = row + col / 8;
        int newCol = (col + 1) % 9;

        for (int num = 1; num <= 9; num++) {
            if (isValid(board, row, col, num)){
                board[row][col] = (char) (num + '0');
                boolean result = solveSudokuHelper(board, newRow, newCol);
                if (result) return true;
                board[row][col] = '.'; //回溯回去，重新设置为'.';
            }
        }
        return false;

    }
    public void solveSudoku2(char[][] board) {
        if (board == null || board.length == 0) return;
        solveHelper(board);
    }

    public boolean solveHelper(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.'){
                    for (char c = '1'; c <= '9' ; c++) {
                        if (isValid(board, i, j, c)){
                            board[i][j] = c;
                            if (solveHelper(board)) return true;
                            else board[i][j] = '.';
                        }

                    }
                    return false;
                }

            }

        }
        return true;
    }
    //
    public boolean isValid2(char[][] board, int row, int col, char c){
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == c) return false;
            if (board[row][i] != '.' && board[row][i] == c) return false;
        }
        int rowoff = (row / 3) * 3;
        int coloff = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowoff + i][coloff + j] == c) return false;
            }
        }
        return true;
    }

    //是否能够将num填入9 * 9的cube中
    public boolean isValid(char[][] board, int row, int col, int num){
        //check column and row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num + '0' || board[i][col] == num + '0') return false;
        }
        //check 3 * 3 square
        int rowoff = (row / 3) * 3;
        int coloff = (col / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[rowoff + i][coloff + j] == num + '0') return false;
            }
        }
        return true;
    }
}
