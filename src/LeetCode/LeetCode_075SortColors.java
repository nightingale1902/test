package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-15
 */
public class LeetCode_075SortColors {
    /*给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，
    并按照红色、白色、蓝色顺序排列。此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色*/
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1;
        int less = l - 1;
        int more = r + 1;
        while (l < more){
            if(nums[l] < 1) swapHelper(nums, ++less, l++);
            else if(nums[l] > 1) swapHelper(nums, --more, l);
            else l++;
        }

    }
    public void swapHelper(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void sortColors2(int[] nums) {
        int element = 0;//元素（0，1，2）
        int temp;
        int index = 0;
        while (element < 3) {
            while (nums[index] == element){//从第一个与位置不匹配的数开始
                if (index == nums.length - 1)
                    break;
                index++;
            }
            for (int j = index + 1; j < nums.length; j++){//从这个数往后扫描，遇到正确元素，调换位置
                if (nums[j] == element) {
                    temp = nums[index];
                    nums[index] = nums[j];
                    nums[j] = temp;
                    index++;//调换后，索引+1，此时这个数仍旧不是正确
                }
            }
            element++;//一次扫描完成后，该元素的位置已经正确，排列下一个元素
        }
    }
}
