class Solution {
    public int ladderLength(String b, String e, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Deque<String> d = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        int level = 1;
        d.offer(b);
        d.offer(null);
        visited.add(b);

        while (!d.isEmpty()) {
            String word = d.poll();
            if (word == null) {
                if (!d.isEmpty()) {
                    d.offer(null);
                }
                level += 1;
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
                        d.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
