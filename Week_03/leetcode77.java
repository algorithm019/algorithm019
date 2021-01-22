class leetcode77 {
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return res;
    }

    public void dfs(int cur, int n, int k) {
        // terminator
        if (temp.size() + (n - cur + 1) < k) {
            return;
        }
        if (temp.size() == k) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }
}