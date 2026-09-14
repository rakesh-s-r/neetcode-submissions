class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (!set.contains(n)) {
            set.add(n);
            n = dfs(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    public int dfs(int n) {
        int res = 0;
        while (n != 0) {
            int temp = n % 10;
            res += (temp * temp);
            n = n / 10;
        }
        return res;
    }
}
