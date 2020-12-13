class leetcode647 {
    public int countSubstrings(String s) {
        int n=s.length();
        int dp[][]=new int[n][n];
        int nums=s.length();

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i < 3){
                        dp[i][j] = 1;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } 
                if (dp[i][j]==1 ){
                    nums++;
                }
            }
        }return nums;

    }
}