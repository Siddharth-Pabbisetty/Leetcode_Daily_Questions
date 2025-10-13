//Daily problem of 3rd october

class Solution {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] v = new int[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                v[i][j] = heightMap[i][j];
            }
        }

        boolean b = true;
        boolean init = true;

        while (b)
        {
            b = false;
            for (int i = 1; i < m - 1; i++)
            {
                for (int j = 1; j < n - 1; j++)
                {
                    int val = Math.max(heightMap[i][j], Math.min(v[i - 1][j], v[i][j - 1]));
                    if (init || v[i][j] > val)
                    {
                        v[i][j] = val;
                        b = true;
                    }
                }
            }
            init = false;
            for (int i = m - 2; i >= 1; i--)
            {
                for (int j = n - 2; j >= 1; j--)
                {
                    int val = Math.max(heightMap[i][j], Math.min(v[i + 1][j], v[i][j + 1]));
                    if (v[i][j] > val)
                    {
                        v[i][j] = val;
                        b = true;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 1; i < m - 1; i++)
        {
            for (int j = 1; j < n - 1; j++)
            {
                if (v[i][j] > heightMap[i][j])
                    res += v[i][j] - heightMap[i][j];
            }
        }
        return res;
    }
}