class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temp.length];

        for(int i=0; i< temp.length; i++) {
            while(!stack.isEmpty() && stack.peek()[0] < temp[i]) {
                int[] val = stack.pop();
                res[val[1]] = i - val[1];
            }
            stack.push(new int[] {temp[i], i});
        }
        return res;
    }
}
