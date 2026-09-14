class Solution {
    public int reverseBits(int n) {
        int bits = 32;
        List<Integer> res = new ArrayList<>();

        while(bits > 0) {
            int last = n & 1;
            res.add(last);
            n = n >> 1;
            bits--;
        }
        
        int val = 0;
        for(int i=0; i< res.size(); i++) {
            val = val << 1;
            val = val | res.get(i);
        }
        return val;
    }
}
