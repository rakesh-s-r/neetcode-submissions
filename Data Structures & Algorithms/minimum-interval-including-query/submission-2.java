class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int[] qList = Arrays.copyOf(queries, queries.length);
        Arrays.sort(qList);
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0] - y[0]);

        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0;

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
            map.put(q, !heap.isEmpty() ? heap.peek()[0] : -1);
        }
        int[] res = new int[queries.length];
        int idx = 0;
        for (int q: queries) {
            res[idx] = map.get(q);
            idx++;
        }
        return res;
    }
}
