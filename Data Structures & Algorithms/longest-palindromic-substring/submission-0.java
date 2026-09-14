class Solution {
    public String longestPalindrome(String s) {
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String str1 = isPali(s, i, i);
            if (str1.length() > max.length()) {
                max = str1;
            }
            String str2 = isPali(s, i, i + 1);
            if (str2.length() > max.length()) {
                max = str2;
            }
        }
        return max;
    }

    public String isPali(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
