class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] list = Arrays.copyOf(queries, queries.length);
        Arrays.sort(list);
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        int i=0;
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        for(int q: list) {
            while(i < intervals.length && intervals[i][0] <= q) {
                int[] val = intervals[i];
                int cal = val[1] - val[0] + 1;
                heap.offer(new int[] {cal, val[1]});
                i+=1;
            }

            while(!heap.isEmpty() && heap.peek()[1] < q) {
                heap.poll();
            }

            map.put(q, heap.isEmpty() ? -1 : heap.peek()[0]);
        }

        int[] res = new int[list.length];
        for(int j=0; j< queries.length; j++) {
            res[j] = map.get(queries[j]);
        }
        return res;
    }
}
