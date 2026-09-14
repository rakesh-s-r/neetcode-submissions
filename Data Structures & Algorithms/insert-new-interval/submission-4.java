class Solution {
    public int[][] insert(int[][] it, int[] ni) {
        int[][] res = new int[it.length+1][2];
        int i=0, j=0;
        int n = it.length;

        while(i<n && it[i][1] < ni[0]) {
            res[j++] = it[i++];
        }
        while(i < n && it[i][0] <= ni[1]) {
            ni[0] = Math.min(it[i][0], ni[0]);
            ni[1] = Math.max(it[i][1], ni[1]);
            i++;
        }

        res[j++] = ni;

        while(i < n) {
            res[j++] = it[i++];
        }

        return Arrays.copyOf(res, j);
    }
}
