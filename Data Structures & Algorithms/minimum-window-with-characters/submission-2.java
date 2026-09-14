class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int need = tmap.size();
        int have = 0;
        int minL = Integer.MAX_VALUE;
        int[] boundry = new int[] {};

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);
            if (tmap.containsKey(ch) && tmap.get(ch).equals(smap.get(ch))) {
                have += 1;
            }
            while (need == have) {
                if ((right - left + 1) < minL) {
                    boundry = new int[] {left, right};
                    minL = right - left + 1;
                }
                char chs = s.charAt(left);
                smap.put(chs, smap.get(chs) - 1);

                if (tmap.containsKey(chs) && smap.get(chs) < tmap.get(chs)) {
                    have -= 1;
                }
                left += 1;
            }
        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(boundry[0], boundry[1]+1);
    }
}
