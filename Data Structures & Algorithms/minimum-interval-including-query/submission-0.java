class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int[] qList = Arrays.copyOf(queries, queries.length);
        Arrays.sort(qList);

        for (int q : qList) {
            while (i < intervals.length && intervals[i][0] <= q) {
                int[] val = intervals[i];
                int cal = val[1] - val[0] + 1;
                heap.offer(new int[] {cal, val[1]});
                i += 1;
            }

            while (!heap.isEmpty() && heap.peek()[1] < q) {
                heap.poll();
            }

            int val = heap.isEmpty() ? -1 : heap.peek()[0];
            map.put(q, val);
        }
        int[] res = new int[queries.length];
        int idx = 0;
        for (int q : queries) {
            res[idx] = map.get(q);
            idx += 1;
        }
        return res;
    }
}
