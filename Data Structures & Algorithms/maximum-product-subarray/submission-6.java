class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int max = 1, min = 1;

        for (int i : nums) {
            int temp = max;
            max = Math.max(i, Math.max(max * i, min * i));
            min = Math.min(i, Math.min(temp * i, min * i));
            res = Math.max(res, max);
        }
        return res;
    }
}
