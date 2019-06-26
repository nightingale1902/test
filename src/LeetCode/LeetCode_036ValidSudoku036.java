package LeetCode;

import java.util.HashSet;

public class LeetCode_036ValidSudoku036 {
    //重要
    //time:O(n^2) space:O(n)
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> rows = new HashSet<>();
            HashSet<Character> cols = new HashSet<>();
            HashSet<Character> cube = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
                if (board[j][i] != '.' && !cols.add(board[j][i])) return false;
                /* i是行标，j是列标。行标决定一组block的起始位置（因为block为3行，
                   所以除3取整得到组号，又因为每组block为3个，所以需要乘3），
                   列标再细分出是哪个block（因为block是3列，所以除3取整*/
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);

                if (board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3]))
                    return false;
            }
        }
        return true;
    }


    public boolean isValidSudoku2(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') continue;
                if (!valid(board, i, j)) return false;

            }
        }
        return true;
    }
    public boolean valid(char[][] board, int i, int j){
        //行 row
        for (int row = 0; row < board.length; row++) {
            if (row == i) continue;
            if (board[row][j] == board[i][j]) return false;
        }
        //列 col
        for (int col = 0; col < board[0].length; col++) {
            if (col == j) continue;
            if (board[i][col] == board[i][j]) return false;
        }
        //3 * 3 cube
        for (int row = (i / 3) * 3; row < (i / 3 + 1) * 3; row++) {
            for (int col = (j / 3) * 3; col < (j / 3 + 1) * 3; col++) {
                if (row == i && col == j) continue;
                if (board[row][col] == board[i][j]) return false;
            }

        }
        return true;
    }
}
