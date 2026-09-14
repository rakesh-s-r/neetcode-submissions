class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> x[1] - y[1]);
        System.out.println(Arrays.deepToString(intervals));
        int count = 0;
        int prev = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= intervals[prev][1]) {
                prev = i;
                count++;
            }
        }
        return intervals.length - count - 1;
    }
}
