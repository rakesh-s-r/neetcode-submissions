class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length <= 1) {
            return 0;
        }
        int prev = 0;
        int valid = 0;
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                valid++;
            }
        }
        return intervals.length - valid - 1;
    }
}
