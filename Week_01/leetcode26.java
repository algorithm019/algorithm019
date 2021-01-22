class leetcode26 {
    public int removeDuplicates(int[] nums) {
        //two pointer method
        //i is fatser pointer
        //j is a slow pointer
        int i = 0;
        for(int j = 1; j < nums.length; j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}