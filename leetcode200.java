class leetcode200 {
    //use dfs
    void dfs(char[][] grid, int r, int c) {
        int n1 = grid.length;
        int n2 = grid[0].length;
        if (r < 0 || c < 0 || r >= n1 || c >= n2 || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int n1 = grid.length;
        int n2 = grid[0].length;
        int numIsl = 0;
        for (int r = 0; r < n1; ++r) {
            for (int c = 0; c < n2; ++c) {
                if (grid[r][c] == '1') {
                    ++numIsl;
                    dfs(grid, r, c);
                }
            }
        }

        return numIsl;
    }
}
