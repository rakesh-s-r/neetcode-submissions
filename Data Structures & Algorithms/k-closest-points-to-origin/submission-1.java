class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0]-y[0]);

        for(int[] pts: points) {
            int dist = (pts[0] * pts[0]) + (pts[1]*pts[1]);
            heap.offer(new int[] {dist, pts[0], pts[1]});
        }

        int[][] res = new int[k][2];
        while(k-1 >= 0) {
            int[] pts = heap.poll();
            res[k-1][0] = pts[1];
            res[k-1][1] = pts[2];
            k--; 
        }   
        return res;
    }
}
