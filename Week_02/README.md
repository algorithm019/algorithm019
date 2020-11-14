学习笔记
还是一样，主要的内容我都做了思维导图，这里就简写一些把

For hash table:
1.每个key会通过hashing functioin然后最后去到hash table的
eg: lies ,每个字母之和为429， 然后通过hash function,放到hash table
2.如果碰到两个一样的值，那么hashtable就会在后面开始延长，以链表的形式
3.如果设计的比较差的hash table,其实和链表差不多了就，O(n）
4.好的hash table可以有效的避免冲突，达到O（1）
Average
Search: O(1)
Insertion: O(1)
Access: O(1)


For tree:
其实linked list就是特殊化的Tree
Tree就算是特殊化的Graph, 当有cycle的时候其实就是graph了
然后学习了二叉树的遍历：
pre-order: root, left, right
in-order: left, root, right
post-order:left right root
这一块的内容对于递归用的非常多，然后老师强调了其实递归并不是一定是效率低的一个内容

BST：
简单来说就是一个有序的二叉树
三个特点
1. 左子树上 所有结点 的值 均小于它根结点； 
2. 右子树上 所有结点 的值 均大于它根结点； 
3. 以此类推：左、右子树 也分别为二叉查找。 （这就是 重复性 ！）
然后对于删除有一个需要注意：
如果删掉以后需要选择一个节点去替换：那么选择右边的最小的那个来替换
Average
Search: O(logn)
Insertion: O(logn)
Access: O(logn)


For heap:
主要特点：可以迅速找到一堆数中的最大/最小的数据结构
比如大顶堆，这样子find-max:O(1)
但是你会发现这个java实现方式就是用的priorityQueue去实现的，这个在本周作业里面常常用到，很实用

二叉堆性质：
1.一个完全二叉树full binary tree
2.数中任意节点的值>=其子节点的值
一般通过数组实现
关于Index关系：
left children : 2*i +1;
right children: 2*i +2；
partent floor((i-1)/2);

Insert需要特别强调：
新元素都加到heap的尾部，这个和实现有关系
然后heapifyup

Delete max：跟insert类似
先把最后一个元素替换到顶部
然后heapifyDown,具体还是看图理解和复习

for Studying:
这周感觉还可以把，比上周感觉时间分配的更均匀一点，希望下周继续努力，不过由于自己基础感觉有些内容还没学过，可能需要再去学一下
不然有些lamda函数，有点懵，还要这个有一些老师写的什么操作感觉有点看不懂，什么Map.Entry，不知道在干嘛
有空我会在研究一下
