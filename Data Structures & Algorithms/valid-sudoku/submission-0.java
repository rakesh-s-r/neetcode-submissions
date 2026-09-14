class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        HashMap<String, HashSet<Character>> set = new HashMap<>();

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                char ch = board[r][c];
                if (ch == '.') {
                    continue;
                }
                String bx = (r/3) + "," + (c/3);
                rows.putIfAbsent(r,  new HashSet<>());
                cols.putIfAbsent(c,  new HashSet<>());
                set.putIfAbsent(bx,  new HashSet<>());
                if(rows.get(r).contains(ch) || cols.get(c).contains(ch) || set.get(bx).contains(ch)) {
                    return false;
                }
                rows.get(r).add(ch);
                cols.get(c).add(ch);
                set.get(bx).add(ch);
            }
        }
        return true;
    }
}
