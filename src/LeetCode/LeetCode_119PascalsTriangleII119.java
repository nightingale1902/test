package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: YourName
 * @Date: 2019-06-18
 */
public class LeetCode_119PascalsTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex > 33) return null;
        //return getRowHelper(rowIndex + 1).get(getRowHelper(rowIndex + 1).size() - 1);
        return getRowHelper(rowIndex);
    }
/*
    public List<List<Integer>> getRowHelper(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    list.add(1);
                else {
                    Integer a = res.get(i - 1).get(j);
                    Integer b = res.get(i - 1).get(j - 1);
                    list.add(a + b);
                }
            }
            res.add(list);
        }
        return res;
    }*/
    public List<Integer> getRowHelper(int rowIndex){
        List<Integer> list = new ArrayList<Integer>();
        rowIndex++;
        list.add(1);
        int start = 1;
        while (start < rowIndex){
            List<Integer> child = new ArrayList<Integer>();
            child.add(1);
            for (int i = 1;i < start; i++){
                child.add(list.get(i-1) + list.get(i));
            }
            child.add(1);
            list = child;
            start++;
        }
        return list;
    }

    /**
     * 获取杨辉三角的指定行
     * 直接使用组合公式C(n,i) = n!/(i!*(n-i)!)
     * 则第(i+1)项是第i项的倍数=(n-i)/(i+1);
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>(rowIndex + 1);
        long cur = 1;
        for (int i = 0; i <= rowIndex; i++) {
            res.add((int) cur);
            cur = cur * (rowIndex - i) / (i + 1);
        }
        return res;
    }

}
