package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_040CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> results = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        if (candidates == null) return results;
        Arrays.sort(candidates);
        dfs(results, curList, candidates, target, 0);
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
            //去重,巧妙的利用了level位置上的元素不用搜索前面有没有重复的
            if (i != level && candidates[i] == candidates[i - 1]) continue;
            //当前使用的数字加入当前结果集
            curSeq.add(candidates[i]);
            //i + 1
            dfs(results, curSeq, candidates, target - candidates[i], i + 1);
            //回溯的操作，将当前的curSeq删除一个，回溯到上一个。
            curSeq.remove(curSeq.size() - 1);

        }
    }

}
