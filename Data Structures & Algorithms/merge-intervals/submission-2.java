class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        int[] nintervals = res.get(0);

        for(int i=0; i< intervals.length; i++) {
            if(nintervals[1] >= intervals[i][0]) {
                nintervals[1] = Math.max(nintervals[1], intervals[i][1]);
            } else {
                res.add(intervals[i]);
                nintervals = intervals[i];
            }
        }

        return res.toArray(new int[res.size()][2]);

    }
}
