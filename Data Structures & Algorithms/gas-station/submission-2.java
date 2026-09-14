class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalG = 0, totalC = 0;
        for (int i : gas) {
            totalG += i;
        }
        for (int i : cost) {
            totalC += i;
        }

        if (totalC > totalG) {
            return -1;
        }

        int cur = 0, startI = 0;
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                cur = 0;
                startI = i + 1;
            }
        }
        return startI;
    }
}
