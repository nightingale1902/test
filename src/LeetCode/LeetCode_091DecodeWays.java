package LeetCode;

/**
 * @Author: YourName
 * @Date: 2019-06-14
 */
public class LeetCode_091DecodeWays {
    /*
    爬楼梯的改版，动态规划搞定
    if (s.length()<1 || s.at(0) == '0') return 0;
    vector<int> res(s.length()+1, 0);
    res.at(0) = 1;
    res.at(1) = 1;
    for (int i = 1; i < s.length(); i++)
    {
        if (s.at(i) != '0') res.at(i + 1) += res.at(i);
        if ((s.at(i - 1) > '0' && s.at(i - 1) < '2') || (s.at(i - 1) == '2' && s.at(i) < '7'))
            res.at(i + 1) += res.at(i - 1);
            if (res.at(i + 1) == 0) break;
    }
    return res.at(s.length());
    */
    public int numDecodings(String s) {
        if (s.length() < 1 || s.charAt(0) == '0') return 0;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = s.charAt(i - 1) == '0' ? 0 : dp[i - 1];
            //if(i>1 && (s[i-2]=='1' || (s[i-2]=='2' && s[i-1]<='6')))
            if (i > 1 && (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6')))
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}
