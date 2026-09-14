class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: tasks) {
            map.put(ch, map.getOrDefault(ch, 0) +1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for(int i: map.values()) {
            heap.offer(i);
        }

        Deque<int[]> q = new ArrayDeque<>();

        int time = 0;
        while(!q.isEmpty() || !heap.isEmpty()) {
            time++;
            System.out.println(time);
            if(!heap.isEmpty()) {
                int val = heap.poll() - 1;
                if(val > 0) {
                    q.offer(new int[] {val, time+n});
                }
            }

            if(!q.isEmpty() && q.peek()[1] == time) {

                int[] h = q.pollFirst();
                System.out.println(Arrays.toString(h));

                heap.offer(h[0]);
            }
        }
        return time;
    }
}
