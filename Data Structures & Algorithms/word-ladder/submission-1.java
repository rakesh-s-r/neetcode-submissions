class Solution {
    public int ladderLength(String b, String e, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        visited.add(b);
        q.offer(b);
        q.offer(null);

        int level = 1;

        while(!q.isEmpty()) {
            String word = q.poll();

            if(word == null) {
                level+=1;
                if(!q.isEmpty()) {
                    q.offer(null);
                }
                continue;
            }
            if(word.equals(e)) {
                return level;
            }

            for(int i=0; i< word.length(); i++) {
                char[] chs = word.toCharArray();

                for(char ch = 'a'; ch <= 'z'; ch++) {
                    chs[i] = ch;
                    String newWord = new String(chs);
                    if(!visited.contains(newWord) && set.contains(newWord)) {
                        visited.add(newWord);
                        q.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
