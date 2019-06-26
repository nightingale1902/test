package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_052NQueensII052 {
    public int totalNQueens(int n) {
        int count = 0;
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return count;
        helper(res, new int[n], 0);
        count = res.size();
        return count;
    }
    public static void helper(List<List<String>> res, int[] queens, int pos){
        if (pos == queens.length){  // pos -->行, 直到n行结束
            addSolution(res, queens);
            return;
        }
        for (int i = 0; i < queens.length; i++) { //queens[] : [0, 0, 0, 0] 都尝试一边
            queens[pos] = i; //行和列都是n
            if (isValid(queens, pos)){
                helper(res, queens, pos + 1);
            }
        }
    }
    public static void addSolution(List<List<String>> res, int[] queens){
        List<String> list = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) { //从第0行添加
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < queens.length; j++) { //在每一行中找queen的位置，即列的位置queens[i]
                if (queens[i] == j){
                    sb.append('Q');
                }else {
                    sb.append('.');
                }

            }
            list.add(sb.toString());
        }
        res.add(list);
    }
    public static boolean isValid(int[] queens, int pos) {
        for (int i = 0; i < pos; i++) {
            if (queens[i] == queens[pos]) {//是否为同一列上。
                return false;
            } else if (Math.abs(queens[pos] - queens[i]) == (Math.abs(pos - i))) { //是否为同一对角线上
                return false;
            }
        }
        return true;
    }
}
