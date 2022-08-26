package leetcode;

public class MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int rowSize = grid.length;
        int columnSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][columnSize];
        int maxSizeOfIsland = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && visited[i][j] == false) {
                    int newSizeOfIsland = 0;
                    newSizeOfIsland = dfs(grid, visited, i, j, newSizeOfIsland);
                    if (newSizeOfIsland > maxSizeOfIsland) {
                        maxSizeOfIsland = newSizeOfIsland;
                    }
                }
            }
        }
        return maxSizeOfIsland;
    }

    public int dfs(int[][] grid, boolean[][] visited, int i, int j, int newSizeOfIsland) {
        if (grid[i][j] == 1 && visited[i][j] == false) {
            visited[i][j] = true;
            newSizeOfIsland = newSizeOfIsland + 1;
            // processing left side
            if (i - 1 >= 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == false) {
                newSizeOfIsland = dfs(grid, visited, i - 1, j, newSizeOfIsland);
            }

            // processing right side
            if (i + 1 < grid.length && grid[i + 1][j] == 1 && visited[i + 1][j] == false) {
                newSizeOfIsland = dfs(grid, visited, i + 1, j, newSizeOfIsland);
            }

            //processing top side
            if (j - 1 >= 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == false) {
                newSizeOfIsland = dfs(grid, visited, i, j - 1, newSizeOfIsland);
            }

            //processing down side
            if (j + 1 < grid[i].length && grid[i][j + 1] == 1 && visited[i][j + 1] == false) {
                newSizeOfIsland = dfs(grid, visited, i, j + 1, newSizeOfIsland);
            }
        }
        return newSizeOfIsland;
    }
}
