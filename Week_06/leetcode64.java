class leetcode64 {
    public int minPathSum(int[][] grid) {
        //动态规划，从上倒下，累加
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length, columns = grid[0].length;
        //状态数组
        int[][] dp = new int[rows][columns];
        //初始化00
        dp[0][0] = grid[0][0];
        //让第一行都先＋，因为只能右/下，这个情况只能右
        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //让第一列都先＋，因为只能右/下，这个情况只能下
        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        //对其他的数加法
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        //最后一个元素就是最短路径
        return dp[rows - 1][columns - 1];
    }
}