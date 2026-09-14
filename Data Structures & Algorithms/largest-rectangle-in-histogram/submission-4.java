class Solution {
    public int largestRectangleArea(int[] nums) {
        Stack<int[]> stack = new Stack<>();

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[0] >= nums[i]) {
                int[] prev = stack.pop();
                max = Math.max(max, prev[0] * (i - prev[1]));
                start = prev[1];
            }
            stack.push(new int[] {nums[i], start});
        }

        for (int i = 0; i < stack.size(); i++) {
            int[] prev = stack.get(i);

            max = Math.max(max, prev[0] * (nums.length - prev[1]));
        }
        return max;
    }
}
