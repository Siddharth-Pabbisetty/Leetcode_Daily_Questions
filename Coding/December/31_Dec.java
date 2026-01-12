// Daily Problem 31st December

class Solution {
    private int[] parent, rank;
    private int r,c;
    private int top,bottom;

    public int latestDayToCross(int row, int col, int[][] cells) {
        r=row;
        c=col;
        int n=row*col;
        parent=new int[n+2];
        rank=new int[n+2];
        top=n;
        bottom=n+1;
        for(int i=0;i<n+2;i++)
            parent[i]=i;
        boolean[][] land=new boolean[row][col];
        int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
        for(int d=cells.length-1;d>=0;d--)
        {
            int r1=cells[d][0]-1;
            int c1=cells[d][1]-1;
            land[r1][c1]=true;
            int id=r1*c+c1;
            for(int[] di:dir)
            {
                int nr=r1+di[0],nc=c1+di[1];
                if(nr>=0 && nc>=0 && nr<r && nc<c && land[nr][nc])
                {
                    solve(id,nr*c+nc);
                }
            }
            if(r1==0)
                solve(id, top);
            if(r1==r-1)
                solve(id, bottom);
            if (find(top) == find(bottom))
                return d;
        }

        return 0;
    }

    private int find(int x) {
        if (parent[x]!=x)
            parent[x]=find(parent[x]);
        return parent[x];
    }

    private void solve(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b)
            return;
        if(rank[a]<rank[b])
            parent[a]=b;
        else if(rank[a] > rank[b])
            parent[b]=a;
        else
        {
            parent[b]=a;
            rank[a]++;
        }
    }
}