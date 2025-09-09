//Daily Problem 2nd September

class Solution {
    public int numberOfPairs(int[][] points) {
        int ans=0;
        int size=points.length;

        for(int i=0; i<size; i++)
        {
            int x=points[i][0],y=points[i][1];
            for(int j=0; j<size; j++)
            {
                if(i == j)
                    continue;
                int m=points[j][0];
                int n=points[j][1];
                if(x>m || y<n)
                    continue;

                boolean f=true;
                for(int k=0; k<size; k++)
                {
                    if(k == i || k == j)
                        continue;
                    int a=points[k][0];
                    int b=points[k][1];
                    if((a>=x && a<=m) && (b<=y && b>=n))
                    {
                        f=false;
                        break;
                    }
                }
                if(f == true)
                    ans++;
            }
        }
        return ans;
    }

}
