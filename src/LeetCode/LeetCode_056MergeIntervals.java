package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LeetCode_056MergeIntervals {
    /*以start的值从小到大来排序，排完序我们就可以开始合并了，首先把第一个区间存入结果中，然后从第二个开始遍历区间集，
    如果结果中最后一个区间和遍历的当前区间无重叠，直接将当前区间存入结果中。
    如果有重叠，将结果中最后一个区间的end值更新为结果中最后一个区间的end和当前end值之中的较大值，
    然后继续遍历区间集，以此类推可以得到最终结果*/
    public int[][] merge(int[][] intervals) {
        if(intervals == null || intervals.length <= 1) return intervals;
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int i = 0;
        int n = intervals.length; //行
        while (i < n){
            int left = intervals[i][0];//区间左端点
            int right = intervals[i][1];//区间右端点
            while (i < n - 1 && right >= intervals[i + 1][0]){
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            list.add(new int[]{left, right});
            i++;
        }
        return list.toArray(new int[list.size()][2]);
    }

}
