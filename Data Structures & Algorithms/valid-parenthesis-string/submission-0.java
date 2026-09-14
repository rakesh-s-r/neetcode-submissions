class Solution {
    public boolean checkValidString(String s) {
        int leftMax = 0, leftMin = 0;
        for(char ch: s.toCharArray()) {
            if(ch == '(') {
                leftMax++;
                leftMin++;
            } else if(ch == ')') {
                leftMax--;
                leftMin--;
            } else {
                leftMax++;
                leftMin--;
            }
            if(leftMax < 0) {
                return false;
            }
            if(leftMin < 0) {
                leftMin = 0;
            }
        }
        return leftMin == 0;
    }
}
