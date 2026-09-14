class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;

        for(int i=0; i< heights.length; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[0] >= heights[i]) {
                int[] prev = stack.pop();
                max = Math.max(max, prev[0] * (i - prev[1]));
                start = prev[1];
            }
            stack.push(new int[] {heights[i], start});
        }

        for(int i=0; i< stack.size(); i++) {
            int[] prev = stack.get(i);
            max = Math.max(max, prev[0] * (heights.length - prev[1]));
        }
        return max;
    }
}
