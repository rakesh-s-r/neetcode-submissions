class Solution {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(0, 0, "", n);
        return res;
    }

    public void dfs(int left, int right, String s, int n) {
        if(n*2 == s.length()) {
            res.add(s);
            return;
        }

        if(left < n) {
            dfs(left+1, right, s + "(", n);
        }

        if(right < left) {
            dfs(left, right+1, s + ")", n);
        }
    }
}
