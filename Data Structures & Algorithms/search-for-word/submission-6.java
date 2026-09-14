class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, cols = board[0].length;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // if (board[i][j] == word.charAt(i)) {
                    if (dfs(i, j, set, board, rows, cols, word, 0)) {
                        return true;
                    }
                // }
            }
        }
        return false;
    }

    public boolean dfs(
        int i, int j, HashSet<String> set, char[][] board, int r, int c, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        String bi = i + "," + j;
        if (i < 0 || j < 0 || i >= r || j >= c
            || board[i][j] != word.charAt(index) || set.contains(bi)) {
            return false;

        }

        set.add(bi);
        if (dfs(i + 1, j, set, board, r, c, word, index + 1)
            || dfs(i, j + 1, set, board, r, c, word, index + 1)
            || dfs(i, j - 1, set, board, r, c, word, index + 1)
            || dfs(i - 1, j, set, board, r, c, word, index + 1)) {
            return true;
        }
        set.remove(bi);
        return false;
    }
}
