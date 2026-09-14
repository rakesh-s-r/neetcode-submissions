class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int val = i, count = 0;
            while (val != 0) {
                count += val & 1;
                val = val >> 1;
            }
            res[i] = count;
        }
        return res;
    }
}
