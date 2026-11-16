// Daily Problem 28th October

class Solution {
    static final int LIM = 1 << 10;
    public int minCost(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Set<Integer>[] st=new HashSet[n];
        st[0]=new HashSet<>();
        st[0].add(grid[0][0]);
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    continue;
                }
                Set<Integer> prev=new HashSet<>();
                if(i>0)
                {
                    prev.addAll(st[j]);
                }
                if(j>0)
                {
                    prev.addAll(st[j-1]);
                }
                Set<Integer> curr=new HashSet<>();
                for(int k:prev)
                {
                    curr.add(k ^ grid[i][j]);
                }
                st[j]=curr;
            }
        }
        for(int i=0;i<LIM;i++)
        {
            if(st[n-1].contains(i))
            {
                return i;
            }
        }
        return 0;
    }
}