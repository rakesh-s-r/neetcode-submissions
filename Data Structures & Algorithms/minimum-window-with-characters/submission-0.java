class Solution {
    public String minWindow(String s, String t) {
        if (t.equals("")) {
            return "";
        }
        HashMap<Character, Integer> smap = new HashMap<>();
        HashMap<Character, Integer> tmap = new HashMap<>();

        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        int need = tmap.size(), have = 0;
        int[] boundaries = new int[] {-1, -1};
        int minL = Integer.MAX_VALUE;
        int left = 0;
        System.out.println(tmap);

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            if (tmap.containsKey(ch) && tmap.get(ch).equals(smap.get(ch))) {
                have += 1;
            }

            while (have == need) {
                System.out.println(have);
                if ((right - left + 1) < minL) {
                    boundaries = new int[] {left, right};
                    minL = (right - left + 1);
                }

                char leftChar = s.charAt(left);
                smap.put(leftChar, smap.get(leftChar) - 1);

                if (tmap.containsKey(leftChar) && smap.get(leftChar) < tmap.get(leftChar)) {
                    have--;
                }
                left += 1;
            }
        }
        return minL == Integer.MAX_VALUE ? "" : s.substring(boundaries[0], boundaries[1] + 1);
    }
}
