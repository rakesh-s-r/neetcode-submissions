class Solution {
    HashSet<String> set = new HashSet<>();
    Deque<int[]> q = new ArrayDeque<>();

    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 0) {
                    q.offerLast(new int[] {r, c});
                    set.add(r + "," + c);
                }
            }
        }

        int dist = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] prev = q.pollFirst();
                int r = prev[0], c = prev[1];
                grid[r][c] = dist;
                dfs(r + 1, c, rows, cols, grid);
                dfs(r - 1, c, rows, cols, grid);
                dfs(r, c + 1, rows, cols, grid);
                dfs(r, c - 1, rows, cols, grid);
            }
            dist += 1;
        }
    }

    public void dfs(int r, int c, int rows, int cols, int[][] grid) {
        String bx = r + "," + c;
        if (r < 0 || c < 0 || r >= rows || c >= cols || set.contains(bx) || grid[r][c] == -1) {
            return;
        }
        set.add(bx);
        q.offer(new int[] {r, c});
    }
}
