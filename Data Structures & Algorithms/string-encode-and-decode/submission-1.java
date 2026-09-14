class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for(String s: strs) {
            res+=s.length() + "#" + s;
        }
        return res;
    }

    public List<String> decode(String str) {
        int i=0;
        List<String> res = new ArrayList<>();

        while(i < str.length()) {
            int j = i;
            while( str.charAt(j)!= '#') {
                j+=1;
            }
            int len = Integer.valueOf(str.substring(i, j));
            res.add(str.substring(j+1, j+1+len));
            i = j+1+len;
        }
        return res;
    }
}
