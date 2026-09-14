class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, board, new HashSet<>(), 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] board, HashSet<String> set, int index, String s) {
        if(index >= s.length()) {
            return true;
        }
        String bx = i + "," + j;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || set.contains(bx)
            || board[i][j] != s.charAt(index)) {
            return false;
        }
        set.add(bx);
        if (dfs(i + 1, j, board, set, index + 1, s) || dfs(i - 1, j, board, set, index + 1, s)
                || dfs(i, j + 1, board, set, index + 1, s) || dfs(i, j - 1, board, set, index + 1, s)) {
            return true;
        }
        set.remove(bx);
        return false;
    }
}
