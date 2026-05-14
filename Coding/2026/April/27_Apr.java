// Daily Problem 27th April

class Solution {
    private static final int[][] state = {
            {-1, 1, -1, 3},
            {0, -1, 2, -1},
            {3, 2, -1, -1},
            {1, -1, -1, 2},
            {-1, 0, 3, -1},
            {-1, -1, 1, 0}
    };
    private static final int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int[][] start = {{1, 3}, {0, 2}, {2, 3},
            {1, 2}, {0, 3}, {0, 1}};

    public boolean hasValidPath(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(m==1 && n==1)
        {
            return true;
        }

        int[] arr=start[grid[0][0] - 1];
        return check(grid,arr[0]) || check(grid,arr[1]);
    }

    private boolean check(int[][] grid, int dir) {
        if(dir==-1)
        {
            return false;
        }
        int m=grid.length;
        int n=grid[0].length;
        int r=direction[dir][0];
        int c=direction[dir][1];
        while(r>=0 && r<m && c>=0 && c<n)
        {
            dir=state[grid[r][c] - 1][dir];
            if(dir==-1 || r==0 && c==0)
            {
                return false;
            }
            if(r==m-1 && c==n-1)
            {
                return true;
            }
            r+=direction[dir][0];
            c+=direction[dir][1];
        }
        return false;
    }
}