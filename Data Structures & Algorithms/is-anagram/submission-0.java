class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> s_map = new HashMap<>();
        HashMap<Character, Integer> t_map = new HashMap<>();

        for(char ch: s.toCharArray()) {
            s_map.put(ch, s_map.getOrDefault(ch, 0) + 1);
        }

        for(char ch: t.toCharArray()) {
            t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
        }

        return s_map.equals(t_map);
    }
}
