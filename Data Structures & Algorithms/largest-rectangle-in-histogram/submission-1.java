class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int max = 0;
        for(int i=0; i< heights.length; i++) {
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] >= heights[i]) {
                int[] prev = stack.pop();
                max = Math.max(max, prev[1] * (i - prev[0]));
                start = prev[0];
            }
            stack.push(new int[] {start, heights[i]});
        }

        for(int i=0; i< stack.size(); i++) {
            int[] prev = stack.get(i);
            max = Math.max(max, prev[1] * (heights.length - prev[0]));
        }
        return max;
    }
}
