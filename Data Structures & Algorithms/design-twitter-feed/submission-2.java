class Twitter {
    HashMap<Integer, Set<Integer>> u = new HashMap<>();
    int count = 0;
    HashMap<Integer, List<int[]>> t = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        if (!t.containsKey(userId)) {
            t.put(userId, new ArrayList<>());
        }
        count++;
        t.get(userId).add(new int[] {count, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        if (!u.containsKey(userId)) {
            u.put(userId, new HashSet<>());
        }
        u.get(userId).add(userId);

        PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        for (int usr : u.get(userId)) {
            if (t.containsKey(usr)) {
                int lastI = t.get(usr).size() - 1;
                int[] val = t.get(usr).get(lastI);
                q.offer(new int[] {val[0], val[1], usr, lastI - 1});
            }
        }

        List<Integer> list = new ArrayList<>();

        while (!q.isEmpty() && list.size() < 10) {
            int[] val = q.poll();
            list.add(val[1]);
            int index = val[3];
            if (index >= 0) {
                int[] new_set = t.get(val[2]).get(index);
                q.offer(new int[] {new_set[0], new_set[1], val[2], index - 1});
            }
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        if (!u.containsKey(followerId)) {
            u.put(followerId, new HashSet<>());
        }
        u.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        u.get(followerId).remove(followeeId);
    }
}
