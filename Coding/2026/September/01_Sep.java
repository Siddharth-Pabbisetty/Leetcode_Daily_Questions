// Daily Problem 1st September

class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m=classroom.length;
        int n=classroom[0].length();
        int[][] arr=new int[m][n];
        int startX=-1,startY=-1;
        int cnt=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                char ch=classroom[i].charAt(j);
                if(ch=='S')
                {
                    startX=i;
                    startY=j;
                }
                else if(ch=='L')
                {
                    arr[i][j]=cnt++;
                }
            }
        }

        if(cnt==0)
        {
            return 0;
        }
        int targetMask=(1<<cnt)-1;
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{startX,startY,energy,0,0});
        boolean[][][][] b=new boolean[m][n][energy+1][1<<cnt];
        b[startX][startY][energy][0] = true;
        int[] directions={-1,0,1,0,-1};
        while(!q.isEmpty())
        {
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int e=curr[2];
            int mask=curr[3];
            int steps=curr[4];
            for(int i=0;i<4;i++)
            {
                int nr=r+directions[i];
                int nc=c+directions[i+1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && classroom[nr].charAt(nc)!='X')
                {
                    int nxt_e=e-1;
                    int nxt_mask=mask;
                    char nextCell=classroom[nr].charAt(nc);
                    if(nextCell=='L')
                    {
                        nxt_mask|=(1<<arr[nr][nc]);
                    }
                    if(nxt_mask==targetMask)
                    {
                        return steps+1;
                    }
                    if(nextCell=='R')
                    {
                        nxt_e=energy;
                    }
                    if(nxt_e==0 && nextCell!='R')
                    {
                        continue;
                    }
                    if(!b[nr][nc][nxt_e][nxt_mask])
                    {
                        b[nr][nc][nxt_e][nxt_mask]=true;
                        q.offer(new int[]{nr,nc,nxt_e,nxt_mask,steps+1});
                    }
                }
            }
        }
        return -1;
    }
}