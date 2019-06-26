package LeetCode;

import java.util.*;

/**
 * @Author: YourName
 * @Date: 2019-06-07
 */
public class LeetCode_895FreqStack895 {
    //优先队列，用index判断谁离栈顶近
    private int index;
    private  Map<Integer, Integer> map;
    private PriorityQueue<int[]> queue;//队列元素包含：1. 值 2. 次数 3. 与栈顶距离

    public LeetCode_895FreqStack895() {
        queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]){ //比较count
                    return o2[2] - o1[2];//比较index，与栈顶的距离
                }
                return o2[1] - o1[1];
            }
        });
        map = new HashMap<>();
        index = 0;

    }

    public void push(int x) {
        int count = map.getOrDefault(x, 0) + 1;//记录x的次数
        map.put(x, count);
        queue.add(new int[]{x, count, index++});


    }

    public int pop() {
        int[] poll = queue.poll();
        map.put(poll[0], poll[1] - 1);
        return poll[0];

    }

/*    int maxFreq;
    private Map<Integer, Integer> freq;
    private Map<Integer, List<Integer>> m;
    public void push2(int x){


    }*/


}
