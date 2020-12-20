学习笔记
# 字典树和并查集

## 字典树Trie
### definition
字典树，即 Trie 树，又称单词
查找树或键树，是一种树形结
构
1. 结点本身不存完整单词；
2. 从根结点到某一结点，路径上经过的字符连接起来，为该结点对应的
字符串；
3. 每个结点的所有子结点路径代表的字符都不相同

### advantage

最大限度地减少
无谓的字符串比较，查询效率
比哈希表高。

### 核心思想

1. Trie 树的核心思想是空间换时间。
2. 利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

### sample code
```
class Trie(object):
  def __init__(self):
    self.root = {}
    self.end_of_word = "#"
  def insert(self, word):
    node = self.root
    for char in word:
      node = node.setdefault(char, {})
    node[self.end_of_word] = self.end_of_word
  def search(self, word):
     node = self.root
     for char in word:
        if char not in node:
            return False
        node = node[char]
      return self.end_of_word in node
  def startsWith(self, prefix):
    node = self.root
    for char in prefix:
      if char not in node:
        return False
      node = node[char]
    return True

```

## 并查集 Disjoint Set
### 基本操作
• makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。
• unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在
的集合不相交，如果相交则不合并。
• find(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元
素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。


### sample code
```
class UnionFind {
  private int count = 0;
  private int[] parent;
  public UnionFind(int n) {
    count = n;
    parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
  }
  }
  public int find(int p) {
    while (p != parent[p]) {
      parent[p] = parent[parent[p]];
      p = parent[p];
  }
  return p;
  }
  public void union(int p, int q) {
    int rootP = find(p);
    int rootQ = find(q);
    if (rootP == rootQ) return;
    parent[rootP] = rootQ;
    count--;
  }
}

```
# 高级搜索
## 初级搜索
1. 朴素搜索
2. 优化方式：不重复（fibonacci）、剪枝（生成括号问题）
3. 搜索方向：
  DFS: depth first search 深度优先搜索
  BFS: breadth first search 广度优先搜索
  双向搜索、启发式搜索
## 剪枝
eg: 三子棋、五子棋
主要通过次操作来减少很多多余的操作，来加快运行
有的复杂度特别大，如果不做剪枝，会崩溃

## 回溯法
### definition
1. 回溯法采用试错的思想，它尝试分步的去解决一个问题
2. 在分步解决问题的过程中，当它通过尝试发现现有的分步答案不能得到有效的正确的解答的时候，
它将取消上一步甚至是上几步的计算，再通过其它的可能的分步解答再次尝试寻找问题的答案。
Key words: 试差思想，部分解决，无法解决就取消上一步骤

### 实现
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种情况：
• 找到一个可能存在的正确的答案
• 在尝试了所有可能的分步方法后宣告该问题没有答案
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。


## 双向 BFS： Two-ended BFS
简单来说就是两个bfs同时进行，一个从前开始，一个从后开始

## 启发式搜索 Heuristic Search (A*)

## 估价函数
启发式函数： h(n)，它用来评价哪些结点最有希望的是一个我们要找的结点，
h(n) 会返回一个非负实数,也可以认为是从结点n的目标结点路径的估计成本。
启发式函数是一种告知搜索方向的方法。
它提供了一种明智的方法来猜测哪个邻居结点会导向一个目标。

## sample code
```
def AstarSearch(graph, start, end):
  pq = collections.priority_queue() # 优先级 —> 估价函数
  pq.append([start])
  visited.add(start)
  while pq:
    node = pq.pop() # can we add more intelligence here ?
    visited.add(node)
    process(node)
    nodes = generate_related_nodes(node)
    unvisited = [node for node in nodes if node not in visited]
    pq.push(unvisited)
```
# 高级树、 AVL AVL AVL AVL 树
## AVL tree

1. balance factor: 左子树高度-右子树高度
balance factor ={-1,0,1}
2. 通过旋转操作来进行平衡（四种 ）
### 四种旋转操作
https://en.wikipedia.org/wiki/Tree_rotation#/media/File:Rebalancing.gif
#### case 1. 子树 形态：全右子树
左旋
#### case 2. 子树 形态：全左子树
右旋
#### case 3. 子树 形态：左右子树
左右旋
eg: A left is B & B right is C
#### case 4. 子树 形态：右左子树
右左旋
eg: A right is B & B left is C

### drawbacks
不足：结点需要存储额外信息、且调整次数频繁

## 红黑树 red black tree
红黑树是一种 近似平衡 的二叉搜索树（ BinaryBinaryBinaryBinaryBinaryBinarySearch TreeSearch TreeSearch TreeSearch TreeSearch TreeSearch TreeSearch TreeSearch TreeSearch TreeSearch TreeSearch Tree）， 它能够确保任何一 个结点的 左右子树高度差小于两倍 。具体来说，红黑树是满足如下条件的二叉 搜索树 ：
• 每个结点要么是红色
，黑• 根结点是黑色
• 每个叶 结点（ NILNILNIL结点，空 结点）是黑色的 。
• 不能有相邻接的两个红色 结点
• 从任一 结点到其每个叶子的所有路径都包含相同数目黑色 结点

### 关键性质
从根到叶子的最长可能路径不多于短两倍。

### 对比avl and red balck tree

•	AVL trees providefaster lookupsthan Red Black Trees because they are more strictly balanced.
•	Red Black Trees providefaster insertion and removal operations than AVL trees as fewer rotations are done due to relatively relaxed balancing.
•	AVL trees store balance factors or heights with each node, thus requires storage for an integer per node whereas Red Black Tree requires only 1 bit of information per node.
•	Red Black Trees are used in most of the language libraries likemap, multimap, multisetin C++whereas AVL trees are used in databaseswhere faster retrievals are required.
### leetcode 547

#### use dfs
```
public class Solution {
    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
}

```

#### use bfs
```
public class Solution {
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        Queue < Integer > queue = new LinkedList < > ();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int s = queue.remove();
                    visited[s] = 1;
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0)
                            queue.add(j);
                    }
                }
                count++;
            }
        }
        return count;
    }
}

```

#### use 并查集
```
public class Solution {
    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        if (xset != yset)
            parent[xset] = yset;
    }
    public int findCircleNum(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }
}

```


### leetcode 200 岛屿数量
use dfs
```
class Solution {
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
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

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }

        return num_islands;
    }
}

```



use bfs
```
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}

```
use 并查集
```
class Solution {
    class UnionFind {
        int count;
        int[] parent;
        int[] rank;

        public UnionFind(char[][] grid) {
            count = 0;
            int m = grid.length;
            int n = grid[0].length;
            parent = new int[m * n];
            rank = new int[m * n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (grid[i][j] == '1') {
                        parent[i * n + j] = i * n + j;
                        ++count;
                    }
                    rank[i * n + j] = 0;
                }
            }
        }

        public int find(int i) {
            if (parent[i] != i) parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int x, int y) {
            int rootx = find(x);
            int rooty = find(y);
            if (rootx != rooty) {
                if (rank[rootx] > rank[rooty]) {
                    parent[rooty] = rootx;
                } else if (rank[rootx] < rank[rooty]) {
                    parent[rootx] = rooty;
                } else {
                    parent[rooty] = rootx;
                    rank[rootx] += 1;
                }
                --count;
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        UnionFind uf = new UnionFind(grid);
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    grid[r][c] = '0';
                    if (r - 1 >= 0 && grid[r-1][c] == '1') {
                        uf.union(r * nc + c, (r-1) * nc + c);
                    }
                    if (r + 1 < nr && grid[r+1][c] == '1') {
                        uf.union(r * nc + c, (r+1) * nc + c);
                    }
                    if (c - 1 >= 0 && grid[r][c-1] == '1') {
                        uf.union(r * nc + c, r * nc + c - 1);
                    }
                    if (c + 1 < nc && grid[r][c+1] == '1') {
                        uf.union(r * nc + c, r * nc + c + 1);
                    }
                }
            }
        }

        return uf.getCount();
    }
}

```
