class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            int[] store = new int[26];
            for(char ch: str.toCharArray()) {
                store[ch - 'a']++;
            }
            String key = Arrays.toString(store);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
