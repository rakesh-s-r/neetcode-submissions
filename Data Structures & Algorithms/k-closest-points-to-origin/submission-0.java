class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0]-y[0]);

        for(int[] p: points) {
            int a = p[0];
            int b = p[1];
            int dist = (a*a) + (b*b);
            heap.add(new int[] {dist, a, b});
        }

        int[][] res = new int[k][2];
        while(k > 0) {
            int[] val = heap.poll();
            res[k-1][0] = val[1];
            res[k-1][1] = val[2];
            k--;
        }
        return res;
    }
}
