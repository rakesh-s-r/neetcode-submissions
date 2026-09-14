class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int left = 0;

        Deque<Integer> queue = new ArrayDeque<>();

        for (int right = 0; right < n; right++) {
            while (!queue.isEmpty() && queue.peekFirst() <= right - k) {
                queue.pollFirst();
            }

            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[right]) {
                queue.pollLast();
            }
            queue.offerLast(right);
            if (right >= k - 1) {
                res[left++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
