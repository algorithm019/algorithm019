class leetcode55 {
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