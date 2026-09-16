class Solution {
    public int minCostConnectPoints(int[][] points) {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        int n = points.length;
        for(int i=0; i< n; i++) {
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i< n; i++) {
            int x1 =  points[i][0];
            int y1 =  points[i][1];
            for(int j=i+1; j< n; j++) {
                int x2 =  points[j][0];
                int y2 =  points[j][1];

                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                map.get(i).add(new int[] {dist, j});
                map.get(j).add(new int[] {dist, i});
            }
        }

        int res = 0;
        Set<Integer> set = new HashSet<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> x[0] - y [0]);
        heap.offer(new int[] {0, 0});

        while(set.size() < n) {
            int[] pts = heap.poll();
            if(set.contains(pts[1])) {
                continue;
            }

            res+= pts[0];
            set.add(pts[1]);

            if(map.containsKey(pts[1])) {
                for(int[] p: map.get(pts[1])) {
                    if(!set.contains(p[1])) {
                        heap.offer(p);
                    }
                }
            }
        }
        return res;
    }
}
