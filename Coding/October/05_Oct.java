//Daily problem of 5th october

class Solution {
    private int m, n;
    private int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights)
    {
        m = heights.length;
        n = heights[0].length;
        boolean[][] a = new boolean[m][n];
        boolean[][] b = new boolean[m][n];
        for (int j = 0; j < n; j++)
            dfs(0, j, heights, a);
        for (int i = 0; i < m; i++)
            dfs(i, 0, heights, a);
        for (int j = 0; j < n; j++)
            dfs(m - 1, j, heights, b);
        for (int i = 0; i < m; i++)
            dfs(i, n - 1, heights, b);

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (a[i][j] && b[i][j])
                {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] heights, boolean[][] visited)
    {
        if (visited[i][j])
            return;
        visited[i][j] = true;
        for (int[] d : dir)
        {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= m || y < 0 || y >= n)
                continue;
            if (heights[x][y] < heights[i][j])
                continue;
            dfs(x, y, heights, visited);
        }
    }
}