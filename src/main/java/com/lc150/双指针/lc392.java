package com.lc150.双指针;

public class lc392 {
    public boolean isSubsequence(String s, String t) {
        /**
         z a h b g d c
         a 0 1 - - - - -
         g     1 1 2 - -
         c           2 3

         z a b c
         b 0 0 1 0
         */
        int[] dp = new int[t.length() + 1];
        int j = 1,res = 0;
        for (int i = 1; i <= s.length(); i++) {
            for (; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[j] = dp[j - 1] + 1;
                    res = Math.max(res,dp[j]);
                    j++;
                    break;
                } else {
                    dp[j] = dp[j - 1];
                }
            }
        }
        return res == s.length();
    }
}
