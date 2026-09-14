class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        PriorityQueue<int[]> heap = new PriorityQueue<>((x,y) -> x[0] - y[0]);
        heap.offer(new int[]{0, k});

        for(int[] time: times) {
            map.putIfAbsent(time[0], new ArrayList<>());
            map.get(time[0]).add(new int[] {time[1], time[2]});
        }

        int t = 0;
        while(!heap.isEmpty()) {
            int[] edge = heap.poll();
            if(set.contains(edge[1])) {
                continue;
            }
            t = Math.max(t, edge[0]);
            set.add(edge[1]);

            if(map.containsKey(edge[1])) {
                for(int[] se: map.get(edge[1])) {
                    if(!set.contains(se[0])) {
                        heap.offer(new int[] {edge[0] + se[1], se[0]});
                    }
                }
            }
        }

        if(set.size() == n) {
            return t;
        } else {
            return -1;
        }
    }
}