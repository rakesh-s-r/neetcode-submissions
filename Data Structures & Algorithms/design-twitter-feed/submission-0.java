class Twitter {
    HashMap<Integer, Set<Integer>> userIds = new HashMap<>();
    HashMap<Integer, List<int[]>> tweets = new HashMap<>();
    int post = 0;

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        post++;
        tweets.get(userId).add(new int[] {post, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!userIds.containsKey(userId)) {
            userIds.put(userId, new HashSet<>());
        }
        userIds.get(userId).add(userId);

        PriorityQueue<int[]> heap = new PriorityQueue<>((x, y) -> y[0] - x[0]);

        for (int usr : userIds.get(userId)) {
            if (tweets.containsKey(usr)) {
                int index = tweets.get(usr).size() - 1;
                int[] val = tweets.get(usr).get(index);
                heap.offer(new int[] {val[0], val[1], usr, index - 1});
            }
        }

        List<Integer> l = new ArrayList<>();
        while (!heap.isEmpty() && l.size() < 10) {
            int[] val = heap.poll();
            l.add(val[1]);
            int index = val[3];

            if (index >= 0) {
                int[] new_set = tweets.get(val[2]).get(index);
                heap.offer(new int[] {new_set[0], new_set[1], val[2], index - 1});
            }
        }
        return l;
    }

    public void follow(int followerId, int followeeId) {
        if (!userIds.containsKey(followerId)) {
            userIds.put(followerId, new HashSet<>());
        }
        userIds.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userIds.get(followerId).remove(followeeId);
    }
}
