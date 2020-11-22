# 学习笔记

看了前几周别人总的总结，发现自己好像写的不是很到位，下周好好改进自己，这周时间来不及了！
这周内容其实对我而言有点不太理解，练leetcode时候感觉很差，特别是回溯，分支，这些大学里面都没讲过，其实发现自己大三的话，其实基础可能的确就是差一点。
感觉还是要多花点时间先去理解一下底层的东西。我会加油的！
这周学校的大作业比较多，这上面时间花的就少一点，下周感恩节放假了，可以好好研究一下！

## For 递归呢：
按照四步法:
1.terminator
2.process logic in the current logic 处理当前逻辑
3.drill down 下探到下一层
4.reverse the current level status if needed 清理当前层（这个不是每次都用得到）


### 回顾到之前的树，用的都是递归的思路：
 ``` def preorder(self, root):
  if root:
  self.traverse_path.append(root.val)
  self.preorder(root.left)
  self.preorder(root.right)
def inorder(self, root):
  if root:
  self.inorder(root.left)
  self.traverse_path.append(root.val)
  self.inorder(root.right)
def postorder(self, root):
  if root:
  self.postorder(root.left)
  self.postorder(root.right)
  self.traverse_path.append(root.val)
 ``` 

### Java 代码模版for recursion
 ``` public void recur(int level, int param) {
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

## For 分治:
本质上就是先divide 变成sub-problem,
然后conquer,去给出sub-solution
最后merge在一起，就是solution
原理很简单，但是实操有点难,我还需要多练习去理解一下逻辑

### 分治代码模板（可以理解为比recursion多了一步）
 ``` def divide_conquer(problem, param1, param2, ...):
    //recursion terminator
    if problem is None:
    print_result
    return
    // prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    //conquer subproblems
    subresult1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult3 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    // process and generate the final result
    result = process_result(subresult1, subresult2, subresult3, …)
    // revert the current level states
 ``` 

## For 回溯：
利用试错的思想，分别解决问题
通常就是用递归方法来实现的
在反复重复上述的步骤后可能出现两种情况：
• 找到一个可能存在的正确的答案；
• 在尝试了所有可能的分步方法后宣告该问题没有答案。
