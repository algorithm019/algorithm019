#
# @lc app=leetcode.cn id=20 lang=python3
#
# [20] 有效的括号
#

# @lc code=start
class Solution:
    def isValid(self, s: str) -> bool:
        if len(s) % 2: return False 
        smap = {'(':')', '{': '}', '[': ']', '?': '?'}
        stack = ['?']
        for c in s:
            if c in smap:
                stack.append(c)
            elif smap[stack.pop()] != c:
                return False 
        return stack == ['?']

# @lc code=end

