package LeetCode;

public class LeetCode_045JumpGameII {
    //贪婪算法
    public int jump(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int stepCount = 0;
        int lastJumpMax = 0; //last是上一步能到达的最远位置
        int currentJumpMax = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            currentJumpMax = Math.max(currentJumpMax, i + nums[i]);
            if (i == lastJumpMax){
                stepCount++;
                lastJumpMax = currentJumpMax;
            }
        }
        return stepCount;
    }
    //BFS
    public int jump2(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int level = 0;
        int curMaxArea = 0;
        int maxNext = 0;
        int i = 0;
        while ((curMaxArea - i + 1) > 0){
            level++;
            for (; i <= curMaxArea; i++) {
                maxNext = Math.max(maxNext, nums[i] + i);
                if (maxNext > nums.length - 1){
                    return level;
                }
            }
            curMaxArea = maxNext;
        }
        return 0;
    }
}
