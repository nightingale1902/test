package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_163MissingRanges163 {
//163 time:O(n) space:
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        //step1:Define return value;
        List<String> rst = new ArrayList<>();

      /*1、length() 方法是针对字符串来说的，要求一个字符串的长度就要用到它的length()方法；
        2、length 属性是针对 Java 中的数组来说的，要求数组的长度可以用其 length 属性；
        3、Java 中的 size() 方法是针对泛型集合说的, 如果想看这个泛型有多少个元素, 就调用此方法来查看!*/

        //step2:Handle corner cases
        if (nums == null || nums.length == 0){
            rst.add(lower + "->" + upper);
            return rst;
        }

        //step3:Fill in business logic

        //first:add the range after lower
        addToList(rst, lower, nums[0] - 1); // nums[0] - 1 ?
        //second: add all the range between lower and upper
        int prev = nums[0];
        int i = 1;
        while (i < nums.length){
            int cur = nums[i];
            if (cur != prev + 1){
                addToList(rst, prev + 1, cur - 1);
            }
            prev = cur;
            i++;
        }
        //third: add the range before upper
        addToList(rst, nums[nums.length - 1] + 1, upper);
        return rst;
    }

    //supporting method
    private static void addToList(List<String> rst, int start, int end){
        if (start == end){
            rst.add(String.valueOf(start));
        }else if (start < end){
            rst.add(start + "->" + end);
        }
    }
}