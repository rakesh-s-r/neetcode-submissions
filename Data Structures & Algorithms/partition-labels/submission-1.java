class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length();) {
            int lastIndexOfFirst = s.lastIndexOf(s.charAt(i));
            for (int j = i + 1; j <= lastIndexOfFirst - 1; j++) {
                int lastIndexOfSecondChar = s.lastIndexOf(s.charAt(j));
                if (lastIndexOfSecondChar > lastIndexOfFirst) {
                    lastIndexOfFirst = lastIndexOfSecondChar;
                }
            }
            res.add(lastIndexOfFirst - i + 1);
            i = lastIndexOfFirst + 1;
        }
        return res;
    }
}
