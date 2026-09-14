class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (x, y) -> x[0]-y[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        int[] newI = res.get(0);

        for(int[] interval: intervals) {
            if(interval[0] <= newI[1]) {
                newI[1] = Math.max(interval[1], newI[1]);
            } else {
                newI = interval;
                res.add(newI);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
