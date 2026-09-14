class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, (x, y) -> x[0]-y[0]);

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);

        int[] newI = intervals[0];

        for(int i=0; i< intervals.length; i++) {
            if(intervals[i][0] <= newI[1]) {
                newI[1] = Math.max(newI[1], intervals[i][1]);
            } else {
                newI = intervals[i];
                res.add(newI);
            }
        }

        return res.toArray(new int[res.size()][2]);
    }
}
