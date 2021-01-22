## 毕业总结

#### 回顾学习方法
三分视频理解+7分练习
所以练习才是最重要的
于是引出了我门的五毒神掌刷题法

## 反思以下和小总结
我是一个美本的大三留学生，因为学校的进度太快，感觉基础没打牢固，于是来上了这个训练营，其实还是很值得的，至少信心上提升了太多了。
我觉得之前很多本质和一些关键点我都没搞懂，比如Bfs,dfs的算法，比如分治回溯到底是啥。
有些上课也没有学过的，我也都学了以下，可以说是受益匪浅，
而且发现我上后续课程之中，也发现了很多东西很好用，比如位运算，如果早点来上训练营我可能后期学校课程也能比较轻松了
感觉还是那句话，笨鸟先飞，没有人能随随便便成功的，想成功都得付出一定的努力，更何况cs这个专业更笨不简单
然后自己也有很多小毛病，上学期比较忙，也受限于网课的原因，所以态度上不是狠积极，这个东西其实不是我能控制的，如果有时候我还想把分治和回溯，动态规划去研究一下，感觉还是很缺少练习的。
这门课呢，总体上还是不粗的，除了graph那一块内容少了一点，我门学校还是讲的很多的一块内容，所以有机会，还想再研究一下。



以下回顾一些我觉得对我而言最有帮助的内容
## linked list 
single linked list 时间复杂度
prepend prepend O(1)
append append O(1)
lookup        O(n)
insert insert O(1)
delete delete O(1)
 
### skip list
因为lookup for singule linked list 是O(n)
于是引出了这个skip list
注意：只能用于元素有序的情况 。
所以，跳表 （skip list ）对标的是平衡树 （AVL Tree AVL Tree ）和二分查找， 是一种 插入 /删除 /搜索 都是 O(log n) 的数据结构。 1989 年出现 。
它最大的优势是原理简单、容易实现方便扩展效率更高。因此在一些热门的项目里用来替代平衡树，如 Redis edis、Level evelDB 等
#### 如何优化
增加维度：增加多级索引
在跳表中查询任意数据的时间复杂度就是 O(logn) 


## stack && queue
stack:Last in - First out
queue:Last in - Last out
• Stack：先入后出；添加、删除皆为 O(1)
• Queue：先入先出；添加、删除皆为 O(1)

### sample code
for stack
```
Stack<Integer> stack = new Stack<>();
stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);
System.out.println(stack);
System.out.println(stack.search(4));
stack.pop();
stack.pop();
Integer topElement = stack.peek();
System.out.println(topElement);
System.out.println(" 3的位置 " + stack.search(3));
```
for queue
```
Queue<String> queue = new LinkedList<String>();
queue.offer("one");
queue.offer("two");
queue.offer("three");
queue.offer("four");
System.out.println(queue);
String polledElement = queue.poll();
System.out.println(polledElement);
System.out.println(queue);
String peekedElement = queue.peek();
System.out.println(peekedElement);
System.out.println(queue);
while(queue.size() > 0) {
System.out.println(queue.poll());
}
```
## DOUBLE ended queue
1. 简单理解：两端可以进出的 Queue
Deque - double ended queue
2.插入和删除都是 O(1) 操作
### sample code
for deque
```
Deque<String> deque = new LinkedList<String>();
deque.push("a");
deque.push("b");
deque.push("c");
System.out.println(deque);
String str = deque.peek();
System.out.println(str);
System.out.println(deque);
while (deque.size() > 0) {
System.out.println(deque.pop());
}
System.out.println(deque);
```

## priority queue 这个还挺常用的，特别是高端的数据结构的实现

1. 插入操作：O(1)
2.取出操作：O(logN) - 按照元素的优先级取出
3.底层具体实现的数据结构较为多样和复杂：heap、bst、treap

## hash table
哈希表（ Hash Hash table ）， 也叫散列表，是根据关键码值（ Key value ）

### java code
#### Map: key-value 对，key不重复
-new HashMap()/new TreeMap()
-map.set(key.value)
-map.get(key)
-map.has(key)
-map.size()
-map.clear()

#### set: 不重复元素的集合
-new HashSet()/new TreeSet()
-set.add(value)
-set.delete(value)
-set.hash(value)

## 二叉树
### 遍历（3 kinds）
1. 前序（ Pre -order ）：根 -左-右
2. 中序（ In -order ）：左 -根-右
3. 后序（ Post Post -order ）：左 -右-根

### bst(binary search tree)
二叉搜索树， 也称二叉 排序 树、有序二叉树（ Ordered Binary Tree Binary TreeBinary Tree ）、 排 序二叉树（ Sorted Binary Tree Binary Tree Binary Tree Binary Tree）， 是指一棵空树或者具有下列性质的二叉 树： 
1. 左子树上 所有结点 的值 均小于它根结点； 
2. 右子树上 所有结点 的值 均大于它根结点； 
3. 以此类推：左、右子树 也分别为二叉查找。 （这就是 重复性 ！）


## recursion
最重要的我绝对是模板
Python 代码模版
```
def recursion(level, param1, param2, ...):
# recursion terminator
if level > MAX_LEVEL:
process_result
return
# process logic in current level
process(level, data...)
# drill down
self.recursion(level + 1, p1, ...)
# reverse the current level status if needed
```
Java 代码模版


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
### 思维要点
1. 不要人肉进行递归（最大误区）
2. 找到最近最简方法，将其拆解成可重复解决的问题（重复子问题）
3. 数学归纳法思维

## 分治 Divide & Conquer
### 分治代码模板
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
...
# process and generate the final result
result = process_result(subresult1, subresult2, subresult3, …)
# revert the current level states
```

### Backtracking
## definition
回溯法通常用最简单的递归方法来实现，在反复重复上述的步骤后可能出现两种
情况：
• 找到一个可能存在的正确的答案；
• 在尝试了所有可能的分步方法后宣告该问题没有答案。
在最坏的情况下，回溯法会导致一次复杂度为指数时间的计算。

## bfs and dfs

### Depth-First-Search
DFS 代码 - 递归写法
```
visited = set()
def dfs(node, visited):
if node in visited: # terminator
# already visited
return
visited.add(node)
# process current node here.
...
for next_node in node.children():
if not next_node in visited:
dfs(next node, visited)
```
DFS 代码 - 非递归写法
```

def DFS(self, tree):
if tree.root is None:
return []
visited, stack = [], [tree.root]
while stack:
node = stack.pop()
visited.add(node)
process (node)
nodes = generate_related_nodes(node)
stack.push(nodes)
# other processing work
...
```
### Breadth-First-Search
```
def BFS(graph, start, end):
queue = []
queue.append([start])
visited.add(start)
while queue:
node = queue.pop()
visited.add(node)
process(node)
nodes = generate_related_nodes(node)
queue.push(nodes)
# other processing work
...
```

## greedy
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优（即最有
利）的选择，从而希望导致结果是全局最好或最优的算法。

## 动态规划
1.“Simplifying a complicated problem by breaking it down into
simpler sub-problems” (in a recursive manner)
2.Divide & Conquer + Optimal substructure
分治 + 最优子结构
### key points
动态规划 和 递归或者分治 没有根本上的区别（关键看有无最优的子结构）
共性：找到重复子问题
差异性：最优子结构、中途可以淘汰次优解

### example
1. 最优子结构 opt[n] = best_of(opt[n-1], opt[n-2], …)
2. 储存中间状态：opt[i]
3. 递推公式（美其名曰：状态转移方程或者 DP 方程）
Fib: opt[i] = opt[n-1] + opt[n-2]
二维路径：opt[i,j] = opt[i+1][j] + opt[i][j+1] (且判断a[i,j]是否空地）

## 位运算
1. 将 x 最右边的 n 位清零： x& (~0 << n) & (~0 << n) & (~0 << n) & (~0 << n)
2. 获取 x 的第 n 位值（ 0 或者 1）： (x >> n) & 1 (x >> n) & 1 (x >> n) & 1 (x >> n) & 1 (x >> n) & 1
3. 获取 x 的第 n 位的幂值： x& (1 << & (1 << & (1 << n)
4. 仅将第 n 位置为 1：x | (1 << n) x | (1 << n) x | (1 << n) x | (1 << n) x | (1 << n)
5. 仅将第 n 位置为 0：x & (~ (1 << n)) x & (~ (1 << n)) x & (~ (1 << n)) x & (~ (1 << n)) x & (~ (1 << n)) x & (~ (1 << n))
6. 将 x 最高位至第 n 位（含）清零： x& ((1 << n) & ((1 << n) & ((1 << n) & ((1 << n) -1)
指定位置的运算


