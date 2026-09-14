class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);
        int count = 0, prev = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                count++;
                prev = i;
            }
        }
        return intervals.length - count - 1;
    }
}
