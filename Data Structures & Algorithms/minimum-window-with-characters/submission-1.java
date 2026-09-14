class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("")) {
            return "";
        }
        HashMap<Character, Integer> t_map = new HashMap<>();
        HashMap<Character, Integer> s_map = new HashMap<>();

        for (char ch : t.toCharArray()) {
            t_map.put(ch, t_map.getOrDefault(ch, 0) + 1);
        }

        int[] boundry = new int[] {-1, -1};
        int min = Integer.MAX_VALUE;
        int left = 0;
        int need = t_map.size(), have = 0;

        for (int right = 0; right < s.length(); right++) {
            char chs = s.charAt(right);
            s_map.put(chs, s_map.getOrDefault(chs, 0) + 1);
            if (t_map.containsKey(chs) && s_map.get(chs).equals(t_map.get(chs))) {
                have += 1;
            }

            while (have == need) {
                if ((right - left + 1) < min) {
                    boundry = new int[] {left, right};
                    min = right - left + 1;
                }
                char ch = s.charAt(left);
                s_map.put(ch, s_map.get(ch) - 1);
                left++;
                if (t_map.containsKey(ch) && s_map.get(ch) < t_map.get(ch)) {
                    have -= 1;
                }
            }
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(boundry[0], boundry[1] + 1);
    }
}
