学习笔记
本周学习了两个内容，贪心算法greedy 和2分查找。

# 贪心算法 Greedy
贪心算法是一种在每一步选择中都采取在当前状态下最好或最优的选择，从而希望导致结果是全局最好或最优的算法。
使用场景：1.当你可以证明每一步都是最优解的时候，这个适合就可以直接用
2.由于贪心法的高效性以及其所求得的答案比较接近最优结果，贪心法也可以用作辅助算法或者直接解决一些要求结果不特别精确的问题。


## greedy VS 动态规划
贪心算法与动态规划的不同在于它对每个子问题的解决方案都做出选择，不能回退。
动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能。

## example of greedy
非整除关系的硬币，可选集合：Coins = [10, 9, 1]
求拼出总数为 18 最少需要几个硬币？
Answer:18 - 9 = 9
      9 - 9 = 0


#二分查找
## 二分查找的前提
1. 目标函数单调性（单调递增或者递减）
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible)

代码模版
```
left, right = 0, len(array) - 1
while left <= right:
mid = (left + right) / 2
if array[mid] == target:
# find the target!!
break or return result
elif array[mid] < target:
left = mid + 1
else:
right = mid - 1
```

### for java
```
// Java
public int binarySearch(int[] array, int target) {
    int left = 0, right = array.length - 1, mid;
    while (left <= right) {
        mid = (right - left) / 2 + left;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            right = mid - 1;
        } else {
            left = mid + 1;
        }
    }

    return -1;
}
```

### for python
```
# Python
left, right = 0, len(array) - 1 
while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1
```

# coding exercise:
### leetcode 55 跳跃游戏
```
class Solution {
    public boolean canJump(int[] nums) {
        //巧妙地从后往前greedy
        //greedy分为3种：1. front->back greedy 2. back->front greedy 3. 部分切入，then greedy

        if(nums == null) {
            return false;
        }
        int endReachable = nums.length-1;//从最后开始
        for( int i = nums.length - 1 ; i >=0 ; i--) {
            if(nums[i]+ i >= endReachable) {
                endReachable=i;
                // System.out.println(i);
            }
        }
        //如果能回到0点，说明能够达到初始位置
        return endReachable==0;

    }
}




```
### leetcode122 买卖股票的最佳时机 II
这题看起来很easy，但是主要是你得想到用贪心,整个系列一起看就还不错
```
class Solution {
    public int maxProfit(int[] prices) {
        int res=0;
        for(int i = 1; i< prices.length ; i++) {
            res += Math.max(prices[i]-prices[i-1],0);
        }
        return res;
        
    }
}
```
### leetcode 69. x 的平方根(关于牛顿迭代法)

```
//用二分查找先证明单调性
// y= x^2 --> 单调递增 (x>0)
//方法2：牛顿迭代法
class Solution {
    public int mySqrt(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;


    }
}
```


### leetcode 33. 搜索旋转排序数组
```
class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0 ) return -1;
        //长度=1 的情况
        if(n == 1) return nums[0] == target ? 0 : -1;
        //二分查找算法
        int l=0, r = n-1;
        while(l <= r) {
            int mid = (l+r)/2;
            if(nums[mid] == target) return mid;
            if(nums[0] <= nums[mid]) { //左单调区间
                // if(nums[0] <= target && target < nums[mid]){
                //     r = mid-1;
                // }else {
                //     l= mid+1;
                // }

                (nums[0] <= target && target < nums[mid]) ? r = mid-1:l= mid+1;

            }else {//有单调区间
                // if(nums[mid]<target && target <= nums[r]) {
                //     l= mid+1;

                // }else {
                //     r = mid -1;
                // }

                ( nums[mid]<target && target <= nums[r] )? l= mid+1:r = mid -1;

            }
        }
        return -1;// not fond

    }
}
```
