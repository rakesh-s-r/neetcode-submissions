class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalG = 0, totalC = 0;
        for (int i = 0; i < gas.length; i++) {
            totalG += gas[i];
            totalC += cost[i];
        }

        if (totalC > totalG) {
            return -1;
        }

        int currentGas = 0, startI = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startI = i + 1;
            }
        }
        return startI;
    }
}
