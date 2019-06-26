package LeetCode;

import java.util.*;

public class LeetCode_051NQueens051 {
    /*Input: 4
Output:
 [
  [".Q..",  // Solution 1  queens[] : [1, 3, 0, 2] 数组元素代表queen在每一行的index，即queens[i]的值表示是放在了那一列上。如果存在[1, 1, 0, 2]就不合法
  "...Q",   // pos -->行
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]*/

    //time:O(n*n) space : O(n)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n <= 0) return res;
        helper(res, new int[n], 0);
        return res;
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
   public static boolean isValid(int[] queens, int pos){
       for (int i = 0; i < pos; i++) {
           if (queens[i] == queens[pos]){//是否为同一列上。
               return false;
           }else if (Math.abs(queens[pos] - queens[i]) == (Math.abs(pos - i))){ //是否为同一对角线上
               return false;
           }
       }
       return true;
   }

    public List<List<String>> solveNQueens2(int n) {
        Set<Integer> col = new HashSet<>();
        Set<Integer> z_diagonal = new HashSet<>();
        Set<Integer> f_diagonal = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, res, new ArrayList<String>(), col, z_diagonal, f_diagonal);
        return res;


    }

    private void backtrack(int i, int n, List<List<String>> res, ArrayList<String> tmp, Set<Integer> col, Set<Integer> z_diagonal, Set<Integer> f_diagonal) {
        if (i == n) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!col.contains(j) && !z_diagonal.contains(i + j) && !f_diagonal.contains(i - j)) {
                col.add(j);
                z_diagonal.add(i + j);
                f_diagonal.add(i - j);
                char[] s = new char[n];
                Arrays.fill(s, '.');
                s[j] = 'Q';
                tmp.add(new String(s));
                backtrack(i+1,n,res,tmp,col,z_diagonal,f_diagonal);
                tmp.remove(tmp.size() - 1);
                col.remove(j);
                z_diagonal.remove(i + j);
                f_diagonal.remove(i - j);
            }
        }
    }

}
