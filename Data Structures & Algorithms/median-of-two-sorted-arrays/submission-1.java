class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] large = nums1.length >= nums2.length ? nums1 : nums2;
        int[] small = nums1.length >= nums2.length ? nums2 : nums1;

        int n = (large.length) + small.length;
        int low = 0, high = small.length;

        while (low <= high) {
            int x = (low + high) / 2;
            int y = ((n + 1) / 2) - x;

            int l1 = (x == 0) ? Integer.MIN_VALUE : small[x - 1];
            int r1 = (x == small.length) ? Integer.MAX_VALUE : small[x];

            int l2 = (y == 0) ? Integer.MIN_VALUE : large[y - 1];
            int r2 = (y == large.length) ? Integer.MAX_VALUE : large[y];

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                } else {
                    return Math.max(l1, l2);
                }
            } else if (l1 < l2) {
                low = x + 1;
            } else {
                high = x - 1;
            }
        }
        return 0;
    }
}
