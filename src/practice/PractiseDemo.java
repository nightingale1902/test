package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class PractiseDemo {

    //快捷键ctrl+shift+enter --> 表示为直接收尾。

    //2019年4月29日17:08:26 001
    /*   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
        并返回他们的数组下标。
        你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
        示例:
        给定 nums = [2, 7, 11, 15], target = 9
        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]
    */
    public int[] twoSum01(int[] nums, int target) {
        if ( nums == null || nums.length < 2 ) return new int[2];
        int[] res = new int[2];
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (m.containsKey(target - nums[i])){
                res[0] = m.get(target = nums[i]);
                res[1] = i;
                break;//题目要求假设每种输入只会对应一个答案
            }
            m.put(nums[i], i);
        }
        return res;
    }

    //2019年4月29日17:08:41 002
    /*给出两个非空的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位数字。
    如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
    您可以假设除了数字 0 之外，这两个数都不会以 0 开头。*/
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    /*这道并不是什么难题，算法很简单，链表的数据类型也不难，就是建立一个新链表，
    然后把输入的两个链表从头往后撸，每两个相加，添加一个新节点到新链表后面。
    为了避免两个输入链表同时为空，我们建立一个dummy结点（哑结点其实就是放在第一个存放数据结点之前、头结点之后的结点。
    加入哑结点之后就可以使所有数据结点都有前驱结点，这样就会方便执行链表的一些操作），将两个结点相加生成的新结点按顺序
    加到dummy结点之后，由于dummy结点本身不能变，所以我们用一个指针cur来指向新链表的最后一个结点。这道题好就好在最低位
    在链表的开头，所以我们可以在遍历链表的同时按从低到高的顺序直接相加。while循环的条件两个链表中只要有一个不为空行，
    由于链表可能为空，所以我们在取当前结点值的时候，先判断一下，若为空则取0，否则取结点值。然后把两个结点值相加，
    同时还要加上进位carry。然后更新carry，直接 sum/10 即可，然后以 sum % 10 为值建立一个新结点，连到cur后面，然后cur移动到下一个结点。
    之后再更新两个结点，若存在，则指向下一个位置。while循环退出之后，最高位的进位问题要最后特殊处理一下，若carry为1，则再建一个值为1的结点*/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       //题目已经告诉l1，l2为两个非空的链表 --> 不用做是否为空的检查。
       //新建返回新的链表表示它们的和
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        //while循环退出之后，最高位的进位问题要最后特殊处理一下，
        // 若carry为1，则再建一个值为1的结点
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }

    //2019年4月29日19:17:44 003
    //给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
    /*让我们求最长的无重复字符的子串，注意这里是子串，不是子序列，所以必须是连续的
    *维护了一个滑动窗口，窗口内的都是没有重复的字符，我们需要尽可能的扩大窗口的大小。
    *由于窗口在不停向右滑动，所以我们只关心每个字符最后出现的位置，并建立映射。窗口
    * 的右边界就是当前遍历到的字符的位置，为了求出窗口的大小，我们需要一个变量left
    * 来指向滑动窗口的左边界，这样，如果当前遍历到的字符从未出现过，那么直接扩大右边界，
    * 如果之前出现过，那么就分两种情况，在或不在滑动窗口内，如果不在滑动窗口内，那么就没事，
    * 当前字符可以加进来，如果在的话，就需要先在滑动窗口内去掉这个已经出现过的字符了，
    * 去掉的方法并不需要将左边界left一位一位向右遍历查找，由于我们的HashMap已经保存了
    * 该重复字符最后出现的位置，所以直接移动left指针就可以了。我们维护一个结果res，
    * 每次用出现过的窗口大小来更新结果res，就可以得到最终结果啦 */
    /*left是窗口左边界的前一个位置（这也是left初始化为-1的原因，因为窗口左边界是从0开始遍历的），所以相当于已经移除出滑动窗口了。
    举一个最简单的例子"aa"，当i=0时，我们建立了a->0的映射，并且此时结果res更新为1，
    那么当i=1的时候，我们发现a在HashMap中，并且映射值0大于left的-1，
    所以此时left更新为0，映射对更新为a->1，那么此时i-left还为1，不用更新结果res，那么最终结果res还为1*/
    public int lengthOfLongestSubstring1(String s) {
        int res = 0, left = -1, n = s.length();
	    //key为s的character，value为s的character的index
        HashMap<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            if (m.containsKey(s.charAt(i)) && m.get(s.charAt(i)) > left){
                left = m.get(s.charAt(i));
            }
            m.put(s.charAt(i), i);
            res = Math.max(res, i - left);
        }
        return res;
    }
    /*下面这种写法是上面解法的精简模式，这里我们可以建立一个256位大小的整型数组来代替HashMap，
    这样做的原因是ASCII表共能表示256个字符，但是由于键盘只能表示128个字符，所以用128也行，
    然后我们全部初始化为-1，这样的好处是我们就不用像之前的HashMap一样要查找当前字符是否存在映射对了，
    对于每一个遍历到的字符，我们直接用其在数组中的值来更新left，因为默认是-1，而left初始化也是-1，
    所以并不会产生错误，这样就省了if判断的步骤，其余思路都一样*/
    public int lengthOfLongestSubstring2(String s) {
        int[] m = new int[256];
        Arrays.fill(m, -1);
        int res = 0, left = -1;
        for (int i = 0; i < s.length(); ++i) {
            left = Math.max(left, m[s.charAt(i)]);
            m[s.charAt(i)] = i;
            res = Math.max(res, i - left);
        }
        return res;
    }
    /*使用了set，核心算法和上面的很类似，把出现过的字符都放入set中，遇到set中没有的字符就加入
    set中并更新结果res，如果遇到重复的，则从左边开始删字符，直到删到重复的字符停止
    */
    public int lengthOfLongestSubstring3(String s) {
        int res = 0, left = 0, right = 0;
        HashSet<Character> t = new HashSet<>();
        while (right < s.length()) {
            if (!t.contains(s.charAt(right))) {//不包含相同的character
                t.add(s.charAt(right++)); //添加到集合t中
                res = Math.max(res, t.size());
            } else {
                t.remove(s.charAt(left++));//删除
            }
        }
        return res;
    }

    public int lengthOfLongestSubstring4(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        //i作为终点，而j作为不重复的起点
        for (int i = 0, j = 0; i < s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                //map.get(s.charAt(i)) + 1相当于去除前面部分
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            res = Math.max(res, i - j + 1);
        }
        return res;
    }

    //2019年4月29日20:23:53 004 hard
    /*给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
    请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
    你可以假设 nums1 和 nums2 不会同时为空。*/
    //使用一个小 trick，我们分别找第 (m+n+1) / 2 个，和 (m+n+2) / 2 个，然后求其平均值即可
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length){
            cut1 = (cutR - cutL) / 2 + cutL; //对于num1砍一刀的位置
            cut2 = len / 2 - cut1;            //根据num1砍一刀的位置，得出num2砍一刀的位置
            //L1，R1分别位于cut1的左右；L2，R2分别位于cut2的左右
            double L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1]; //index从0开始的，cut1是等于R1的。
            double L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            double R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            double R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2){
                cutR = cut1 - 1;
            }else if (L2 > R1){
                cutL = cut1 + 1;
            }else {
                if (len % 2 == 0){
                    L1 = L1 > L2 ? L1 : L2;
                    R1 = R1 < R2 ? R1 : R2;
                    return (L1 + R1) / 2;
                }else {
                    R1 = (R1 < R2) ? R1 : R2;
                    return R1;
                }
            }
        }
        return -1;
    }
    //005 2019年5月5日20:09:53
    public String longestPalindrome(String s){
        if (s.length() < 2) return s;
        int n = s.length(), maxlen = 0, start = 0;
        for (int i = 0; i < n; ) {
            //首先判断剩余的字符数是否小于等于 maxLen 的一半，是的话说明 maxLen 无法再变长了，直接break掉
            if (n - i <= maxlen/2) break;
            int left = i, right = i;
            /*，我们用两个变量left和right分别指向当前位置，然后我们先要做的是向右遍历跳过重复项，
            这个操作很必要，比如对于 noon，i在第一个o的位置，如果我们以o为最中心往两边扩散，是无法得到长度为4的回文串的，只有先跳过重复，*/
            while (right < n - 1 && s.charAt(right + 1) == s.charAt(right)) ++ right;
            i = right + 1;
            //向两边扩散
            while (right < n -1 && left > 0 && s.charAt(right + 1) == s.charAt(left - 1)){
                ++right;
                --left;
            }
            if (maxlen < right - left + 1){
                maxlen = right - left + 1;
                start = left;
            }
        }
        return s.substring(start, maxlen + start);
    }
    // 005-2 2019年5月5日20:29:36  马拉车算法查找一个字符串的最长回文子串的线性方法
    public String longestPalindrome2(String s) {
        //http://www.cnblogs.com/grandyang/p/4464476.html
        return s;
    }

    //006 2019年5月5日20:38:01
    //numRows行数
    public String ZigZagConversion006(String s, int numRows){
        if (numRows < 1) return s;
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < sb.length; i++) {
            sb[i] = new StringBuilder("");
        }
        for (int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);
            index = index < numRows ? index : (2 * numRows - 2 -index);
            sb[index].append(s.charAt(i));
        }
        for (int i = 0; i < sb.length; i++) {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }

    //007  2019年5月5日21:13:12
    //
    public int reverse(int x) {
        //int类型的数字倒着写有可能越界所以使用long类型，converse的常用套路。应该加强练习
        long res = 0;
        while (x != 0){
            res = res * 10 + x % 10;
            x /= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)
                return 0;
        }

        return (int) res;
    }

    //008  2019年5月5日21:15:18
}
