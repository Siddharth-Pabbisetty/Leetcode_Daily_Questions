// Daily Problem 10th August

class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] b=new boolean[n+1];
        for(int i=0;i<=n;i++)
        {
            if(!b[i])
            {
                for(int j=1;i+j*j<=n;j++)
                {
                    b[i+j*j]=true;
                }
                if(b[n])
                {
                    return true;
                }
            }
        }
        return false;
    }
}