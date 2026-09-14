class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String left = strs[0];
        String right = strs[strs.length-1];
        String res = "";

        for(int i=0; i< Math.min(left.length(), right.length()); i++) {
            if(left.charAt(i) != right.charAt(i)) {
                return res;
            }
            res+=left.charAt(i);
        }
        return res;
    }
}