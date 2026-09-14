class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i< board.length; i++) {
            for(int j=0; j< board[0].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(dfs(0, i, j, board, new HashSet<>(), word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(int index, int i, int j, char[][] board, Set<String> set, String word) {
        if(index >= word.length()) {
            return true;
        }
        int m = board.length, n = board[0].length;
        String boxIndex = i+","+j;
        if( i< 0 || j<0 || i>= m || j>= n || set.contains(boxIndex) || board[i][j] != word.charAt(index)) {
            return false;
        }

        set.add(boxIndex);
        if(
            dfs(index+1, i+1, j, board, set, word) || 
            dfs(index+1, i-1, j, board, set, word) || 
            dfs(index+1, i, j+1, board, set, word) || 
            dfs(index+1, i, j-1, board, set, word)
        ) {
            return true;
        }
        set.remove(boxIndex);
        return false;
    }
}
