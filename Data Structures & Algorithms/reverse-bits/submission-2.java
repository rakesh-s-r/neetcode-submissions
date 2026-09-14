class Solution {
    public int reverseBits(int n) {
        List<Integer> res = new ArrayList<>();
        int bits = 32;
        while(bits > 0) {
            int temp = n&1;
            n = n >> 1;
            res.add(temp);
            bits--;
        }
        int result = 0;
        for(int i: res) {
            result = result << 1;
            result = result | i;
        }
        return result;
    }
}
