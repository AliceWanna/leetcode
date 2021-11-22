package com.leetCode;

public class pro5 {
    public String longestPalindrome(String s) {
        if(s.length()==0)
            return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen=0;
        int begin=0;
        for(int i =0;i<len;i++)
            dp[i][i] = true;
        for(int j = 1;j<len;j++){
            for(int i = 0;i<j;i++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j-i==1){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                    if (dp[i][j] && j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        begin = i;
                    }
                }
            }
        }
        return s.substring(begin,maxLen+begin);
    }
}
