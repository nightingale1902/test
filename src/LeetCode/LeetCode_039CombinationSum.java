package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//套路
public class LeetCode_039CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(results, result, candidates, target, 0);
        return results;
    }

    public void dfs(List<List<Integer>> results, List<Integer> curSeq, int[] candidates, int target, int level){
        //boundary
        if (target < 0) return;
        if (target == 0){
            //当前结果集加入总的结果集
            results.add(new ArrayList<>(curSeq));
            return;
        }
        //find
        for (int i = level; i < candidates.length && target - candidates[i] >= 0; i++) {
            //当前使用的数字加入当前结果集
            curSeq.add(candidates[i]);
            dfs(results, curSeq, candidates, target - candidates[i], i);
            //回溯的操作，将当前的curSeq删除一个，回溯到上一个。
            curSeq.remove(curSeq.size() - 1);

        }
    }
}
