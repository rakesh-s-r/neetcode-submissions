class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i: nums) {
            set.add(i);
        }

        int max = 0;
        for(int i=0; i< nums.length; i++) {
            if(!set.contains(nums[i] - 1)) {
                int len = 1;
                while(set.contains(nums[i] + len)) {
                    len+=1;
                }
                max = Math.max(max, len);
            }
        }
        return max;
    }
}
