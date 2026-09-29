class Solution {

    Boolean[][][] dp;

    public boolean path(int i, int j, char[][] grid, int balance) {

        // Invalid balance
        if (balance < 0) {
            return false;
        }

        // Out of bounds
        if (i >= grid.length || j >= grid[0].length) {
            return false;
        }

        // Add current character
        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        // Invalid prefix
        if (balance < 0) {
            return false;
        }

        // Destination
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return balance == 0;
        }

        // Already calculated
        if (dp[i][j][balance] != null) {
            return dp[i][j][balance];
        }

        // Move down OR right
        boolean down = path(i + 1, j, grid, balance);
        boolean right = path(i, j + 1, grid, balance);

        return dp[i][j][balance] = down || right;
    }

    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Path length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        dp = new Boolean[m][n][m + n];

        return path(0, 0, grid, 0);
    }
}