class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || j == 0 || i == board.length-1 || j == board[0].length-1) {
                    dfs(i, j, board, new HashSet<>());
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(int i, int j, char[][] board, Set<String> set) {
        String bx = i + "," + j;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || set.contains(bx)
            || board[i][j] != 'O') {
            return;
        }
        set.add(bx);
        board[i][j] = 'T';
        dfs(i + 1, j, board, set);
        dfs(i - 1, j, board, set);
        dfs(i, j + 1, board, set);
        dfs(i, j - 1, board, set);
    }
}
