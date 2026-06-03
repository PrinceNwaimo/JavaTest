package leetCodeProblems;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] used = new boolean[rows][cols];
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' &&!used[i][j]) {
                    dfs(grid, used, rows, cols, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] used, int rows, int cols, int i, int j) {
        // Base case: out of bounds, water, or already visited
        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == '0' || used[i][j]) {
            return;
        }

        used[i][j] = true;

        // Explore 4 directions
        dfs(grid, used, rows, cols, i - 1, j); // up
        dfs(grid, used, rows, cols, i + 1, j); // down
        dfs(grid, used, rows, cols, i, j - 1); // left
        dfs(grid, used, rows, cols, i, j + 1); // right
    }

    public static void main(String[] args) {
        NumberOfIslands solver = new NumberOfIslands();

        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };
        System.out.println(solver.numIslands(grid1)); // 1

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(solver.numIslands(grid2)); // 3

        char[][] grid3 = {
                {'0','0','0'},
                {'0','0','0'}
        };
        System.out.println(solver.numIslands(grid3)); // 0
    }
}
