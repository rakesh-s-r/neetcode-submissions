class Solution {
    HashMap<Character, String> map = new HashMap<>();
    List<String> res = new ArrayList<>();

    public Solution() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) {
            return res;
        }
        dfs(0, digits, "");
        return res;
    }

    public void dfs(int i, String d, String s) {
        if(i >= d.length()) {
            res.add(s);
            return;
        }

        String chs = map.get(d.charAt(i));
        for(char ch: chs.toCharArray()) {
            dfs(i+1, d, s+ch);
        }
    }
}
