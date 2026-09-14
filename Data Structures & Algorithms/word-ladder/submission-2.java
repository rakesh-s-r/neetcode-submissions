class Solution {
    public int ladderLength(String b, String e, List<String> wordList) {
        HashSet<String> visited = new HashSet<>();
        HashSet<String> set = new HashSet<>(wordList);
        Deque<String> q = new LinkedList<>();
        int level = 1;

        visited.add(b);
        q.add(b);
        q.add(null);

        while (!q.isEmpty()) {
            String word = q.poll();

            if (word == null) {
                level++;
                if (!q.isEmpty()) {
                    q.add(null);
                }
                continue;
            }

            if (word.equals(e)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] chs = word.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chs[i] = ch;
                    String newWord = new String(chs);
                    if (!visited.contains(newWord) && set.contains(newWord)) {
                        visited.add(newWord);
                        q.add(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
