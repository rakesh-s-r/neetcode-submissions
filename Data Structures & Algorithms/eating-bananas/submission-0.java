class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0, min = 1;
        for (int i : piles) {
            max = Math.max(i, max);
        }

        while (min < max) {
            int mid = (min + max) / 2;
            if (canDo(piles, mid, h)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }

    public boolean canDo(int[] piles, int mid, int h) {
        int hrs = 0;
        for (int i : piles) {
            hrs += Math.ceil((double) i / mid);
        }
        return hrs <= h;
    }
}
