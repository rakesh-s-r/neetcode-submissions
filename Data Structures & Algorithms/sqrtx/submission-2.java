class Solution {
    public int mySqrt(int x) {
        int left = 0, right = x;
        while (left <= right) {
            int mid = left + (right-left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if ((long) mid * mid > (long) x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }
}