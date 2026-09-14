class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        if(intervals.length <= 1) {
            return 0;
        }
        Arrays.sort(intervals, (x,y) -> x[1]-y[1]);
        System.out.println(Arrays.deepToString(intervals));
        int p = 0;
        for(int i=0; i< intervals.length; i++) {
            if(intervals[i][0] >= intervals[p][1]) {
                p = i;
                count++;
            }
        }
        return intervals.length-count-1;
    }
}
