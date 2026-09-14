class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, sum1 = 0;

        for(int i: nums) {
            sum+=i;
        }

        for(int i=0; i<= nums.length; i++) {
            sum1+=i;
        }

        return sum1 - sum;
    }
}
