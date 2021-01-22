class leetcode1 {
    public int[] twoSum(int[] nums, int target) {
        //先做一个hashtable
        //利用target -nums[i]
        Map<Integer, Integer> hashtable = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length ;i++) {
            if(hashtable.containsKey(target- nums[i])) {
                return new int[]{hashtable.get(target-nums[i]),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];


    }
}