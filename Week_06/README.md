学习笔记

# 动态规划

## 递归代码模版
```
public void recur(int level, int param) {
// terminator
if (level > MAX_LEVEL) {
// process result
return;
}
// process current logic
process(level, param);
// drill down
recur( level: level + 1, newParam);
// restore current status
}


```

## 分治代码模板
```
def divide_conquer(problem, param1, param2, ...):
# recursion terminator
if problem is None:
print_result
return
# prepare data
data = prepare_data(problem)
subproblems = split_problem(problem, data)
# conquer subproblems
subresult1 = self.divide_conquer(subproblems[0], p1, ...)
subresult2 = self.divide_conquer(subproblems[1], p1, ...)
subresult3 = self.divide_conquer(subproblems[2], p1, ...)
…
# process and generate the final result
result = process_result(subresult1, subresult2, subresult3, …)
# revert the current level states

```
### 本质：
寻找重复性 —> 计算机指令集
1. 人肉递归低效、很累
2. 找到最近最简方法，将其拆解成可重复解决的问题
3. 数学归纳法思维（抵制人肉递归的诱惑）

## 动态规划 Dynamic Programming
### defintion
1.“Simplifying a complicated problem by breaking it down into
simpler sub-problems”
(in a recursive manner)

2.Divide & Conquer + Optimal substructure
分治 + 最优子结构

### key points
动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）
共性：找到重复子问题
差异性：最优子结构、中途可以淘汰次优解

### 做题思路：
1. 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], …)
2. 储存中间状态：opt[i]
3. 递推公式（美其名曰：状态转移方程或者 DP 方程）
Fib: opt[i] = opt[n-1] + opt[n-2]
二维路径：opt[i,j] = opt[i+1][j] + opt[i][j+1] (且判断a[i,j]是否空地）

#### 64. 最小路径和
https://leetcode-cn.com/problems/minimum-path-sum/
从上到下的思路
```
class Solution {
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
```

#### 647. 回文子串

```
class Solution {
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
```

