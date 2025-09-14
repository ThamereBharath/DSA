
import java.util.*;

public class numIslands {

    private static void bfs(int row, int col, char[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        vis[row][col] = true;

        int[] drow = {-1, 0, 1, 0};  
        int[] dcol = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + drow[i];
                int nc = c + dcol[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m &&
                        grid[nr][nc] == '1' && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (grid[r][c] == '1' && !vis[r][c]) {
                    count++;
                    bfs(r, c, grid, vis);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        char[][] p = {
                {'1','0','1','0','1'},
                {'0','0','1','0','0'},
                {'1','0','1','0','1'}
        };

        int result = numIslands(p);
        System.out.println("Number of Islands: " + result);  
    }
}
