class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            // maintain index to k
            if(!deque.isEmpty() && deque.peekFirst() <= right-k) {
                deque.pollFirst();
            }

            // remove element less
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]) {
                deque.pollLast();
            }

            deque.offerLast(right);
            if(right >= k-1) {
                res[left++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
