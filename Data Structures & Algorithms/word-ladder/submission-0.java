class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> d = new LinkedList<>();

        d.offer(beginWord);
        d.offer(null);

        visited.add(beginWord);
        int level = 1;

        while (!d.isEmpty()) {
            String word = d.poll();

            if (word == null) {
                level++;
                if (!d.isEmpty()) {
                    d.offer(null);
                }
                continue;
            }

            if (word.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] chs = word.toCharArray();

                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chs[i] = ch;
                    String newWord = new String(chs);

                    if (!visited.contains(newWord) && wordList.contains(newWord)) {
                        d.offer(newWord);
                        visited.add(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
