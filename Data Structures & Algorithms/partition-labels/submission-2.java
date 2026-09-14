class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < s.length();) {
            int lastIndexOne = s.lastIndexOf(s.charAt(i));
            for(int j = i+1; j <= lastIndexOne-1; j++) {
                int secIndexOne = s.lastIndexOf(s.charAt(j));
                if(secIndexOne > lastIndexOne) {
                    lastIndexOne = secIndexOne;
                }
            }
            res.add(lastIndexOne - i + 1);
            i = lastIndexOne + 1;
        }
        return res;
    }
}
