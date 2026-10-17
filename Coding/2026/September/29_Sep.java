// Daily Problem 29th September

class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(((m+n) & 1) == 0 || (grid[0][0] == ')'))
        {
            return false;
        }
        Set<Integer>[][] st=new HashSet[m+1][n+1];
        for(int i=0;i<=m;i++)
        {
            Arrays.setAll(st[i], _ -> new HashSet<>());
        }
        st[0][0].add(0);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                int val=1-((grid[i][j]&1) << 1);
                for(int k:st[i][j])
                {
                    int nk=k+val;
                    if(nk>-1)
                    {
                        st[i+1][j].add(nk);
                        st[i][j+1].add(nk);
                    }
                }
            }
        }
        return st[m][n-1].contains(0);
    }
}