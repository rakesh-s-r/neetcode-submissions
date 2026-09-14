class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);


        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int[] newI = res.get(0);

        for(int i=1; i< intervals.length; i++) {
            if(intervals[i][0] > newI[1]) {
                res.add(intervals[i]);
                newI = intervals[i];
            } else {
                newI[1] = Math.max(newI[1], intervals[i][1]);
            }
        }
        return res.toArray(new int[res.size()][2]);
    }
}
