
import java.util.*;

class Solution {
    static final int MOD = 1000000007;

    public int totalPath(int i, int j, int n, int m,
                         int[][] grid, int[][][] dp, int side) {

        if (i >= n || j >= m) {
            return 0;
        }

        if (i == n - 1 && j == m - 1) {
            return 1;
        }

        if (dp[i][j][side] != -1) {
            return dp[i][j][side];
        }

        long ans = 0;

        if (grid[i][j] == 0) {

            // Move right or down
            ans = (long) totalPath(i, j + 1, n, m,
                    grid, dp, 0)
                + totalPath(i + 1, j, n, m,
                    grid, dp, 1);

        } else {

            // Mirror: entered while moving right
            if (side == 0) {
                ans = totalPath(i + 1, j, n, m,
                        grid, dp, 1);
            }

            // Mirror: entered while moving down
            else {
                ans = totalPath(i, j + 1, n, m,
                        grid, dp, 0);
            }
        }

        return dp[i][j][side] = (int)(ans % MOD);
    }

    public int uniquePaths(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][][] dp = new int[n][m][2];

        for (int[][] row : dp) {
            for (int[] cell : row) {
                Arrays.fill(cell, -1);
            }
        }

        // Initially, robot starts moving right.
        return totalPath(0, 0, n, m, grid, dp, 0);
    }
}
