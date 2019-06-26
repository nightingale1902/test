package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-15
 */
public class LeetCode_079WordSearch079 {
    //dfs+回溯
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (existHelper(board, word.toCharArray(), 0, i, j)){
                    return true;
                }


            }

        }
        return false;

    }
    public boolean existHelper(char[][] board, char[] str, int pos, int x, int y){
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != str[pos])
            return false;
        if (pos + 1 == str.length) return true;
        char temp = board[x][y];
        board[x][y] = '*';
        boolean result = existHelper(board, str, pos + 1, x + 1, y) || existHelper(board, str, pos + 1, x, y + 1)
                || existHelper(board, str, pos + 1, x - 1, y) || existHelper(board, str, pos + 1, x, y - 1);
        board[x][y] = temp;
        return result;
    }
}
