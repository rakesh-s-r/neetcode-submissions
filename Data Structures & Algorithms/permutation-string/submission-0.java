class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] window1 = new int[26];
        int[] window2 = new int[26];

        for(char ch: s1.toCharArray()) {
            window1[ch-'a']++;
        }

        int left = 0;
        for(int right =0; right < s2.length(); right++) {
            window2[s2.charAt(right) - 'a']++;

            if((right-left + 1) >= s1.length()) {
                if(Arrays.equals(window1, window2)) {
                    return true;
                }
                window2[s2.charAt(left) - 'a']--;
                left++;
            }
        }
        return false;
    }
}
