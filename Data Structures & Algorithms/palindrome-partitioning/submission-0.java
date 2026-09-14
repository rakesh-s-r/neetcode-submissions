class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());
        return res;
    }

    public void dfs(int in, String s, List<String> cur) {
        if(in >= s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for(int i=in; i< s.length(); i++) {
            if(isPalindrome(in, i, s)) {
                cur.add(s.substring(in, i+1));
                dfs(i+1, s, cur);

                cur.remove(cur.size()-1);
            }
        }
    }

    public boolean isPalindrome(int left, int right, String s) {
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
