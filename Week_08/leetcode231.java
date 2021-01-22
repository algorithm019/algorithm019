class leetcode231 {
    public boolean isPowerOfTwo(int n) {
        /*
        获取二进制中最右边的 1： x & (-x)


        */
        if (n == 0) 
        	return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }



}