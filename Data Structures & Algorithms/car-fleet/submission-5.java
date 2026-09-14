class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] res = new int[position.length][2];
        for(int i=0; i< position.length; i++) {
            res[i][0] = position[i];
            res[i][1] = speed[i];
        }
        Arrays.sort(res, (x, y) -> (y[0] - x[0]));

        Stack<Double> stack = new Stack<>();
        for(int[] i: res) {
            double val = (double) (target - i[0]) / i[1];
            if(!stack.isEmpty() && val <= stack.peek() ) {
                continue;
            } else {
                stack.push(val);
            }
        }

        return stack.size();
    }
}
