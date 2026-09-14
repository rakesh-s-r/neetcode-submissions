class Twitter {
    HashMap<Integer, Set<Integer>> users = new HashMap<>();
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();
    int time = 0;

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        time++;
        tweets.get(userId).add(new int[] {time, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new HashSet<>());
        }
        users.get(userId).add(userId);

        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        Deque<int[]> q = new ArrayDeque<>();

        for (int usr : users.get(userId)) {
            if (tweets.containsKey(usr)) {
                int index = tweets.get(usr).size() - 1;
                if (index >= 0) {
                    int[] val = tweets.get(usr).get(index);
                    heap.offer(new int[] {val[0], val[1], usr, index - 1});
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty() && res.size() < 10) {
            int[] val = heap.poll();
            res.add(val[1]);
            int ind = val[3];
            if (ind >= 0) {
                int[] newValue = tweets.get(val[2]).get(ind);
                heap.offer(new int[] {newValue[0], newValue[1], val[2], ind - 1});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!users.containsKey(followerId)) {
            users.put(followerId, new HashSet<>());
        }
        users.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        users.get(followerId).remove(followeeId);
    }
}
