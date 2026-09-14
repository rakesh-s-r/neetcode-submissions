class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for(int right=0; right < s.length(); right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while((right-left + 1) - Collections.max(map.values()) > k) {
                char chs = s.charAt(left);
                map.put(chs, map.get(chs) - 1);
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }
}
