class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i=0, j=0, n = intervals.length;
        int[][] res = new int[n+1][2];

        while(i < n && intervals[i][1] < newInterval[0]) {
            res[j++] = intervals[i++];
        }

        while(i<n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res[j++] = newInterval;
        while(i < n) {
            res[j++] = intervals[i++];
        }
        return Arrays.copyOf(res, j);
    }
}
