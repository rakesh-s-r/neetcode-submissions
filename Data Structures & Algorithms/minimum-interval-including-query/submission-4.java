class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);
        int[] qList = Arrays.copyOf(queries, queries.length);
        Arrays.sort(qList);

        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        HashMap<Integer, Integer> map = new HashMap<>();

        int i=0;
        int n = intervals.length;
        for(int q: qList) {
            while(i < n && intervals[i][0] <= q) {
                int a = intervals[i][0];
                int b = intervals[i][1];
                heap.offer(new int[] {b-a+1, b});
                i++;
            }
            while(!heap.isEmpty() && heap.peek()[1] < q) {
                heap.poll();
            }
            int val = heap.isEmpty() ? -1 : heap.peek()[0];
            map.put(q, val);
        }

        int[] res = new int[queries.length];
        for(int j=0; j< queries.length; j++) {
            res[j] = map.get(queries[j]);
        }
        return res;
    }
}