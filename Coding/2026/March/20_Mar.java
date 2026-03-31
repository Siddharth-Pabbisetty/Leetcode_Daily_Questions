// Daily Problem 20th March

class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int r=grid.length, c=grid[0].length;
        int[][] arr=new int[r-k+1][c-k+1];
        for(int i=0;i<=r-k;i++)
        {
            for(int j=0;j<=c-k;j++)
            {
                List<Integer> ls= new ArrayList<>();
                for(int x=i;x<i+k;x++)
                {
                    for(int y=j;y<j+k;y++)
                    {
                        ls.add(grid[x][y]);
                    }
                }
                Collections.sort(ls);
                int mini=Integer.MAX_VALUE;
                int prev=ls.get(0);
                for(int x=1;x<ls.size();x++)
                {
                    if (ls.get(x)!=prev)
                    {
                        mini=Math.min(mini,ls.get(x)-prev);
                    }
                    prev=ls.get(x);
                }
                if(mini==Integer.MAX_VALUE){
                    arr[i][j]=0;
                }
                else
                {
                    arr[i][j]=mini;
                }
            }
        }
        return arr;
    }
}