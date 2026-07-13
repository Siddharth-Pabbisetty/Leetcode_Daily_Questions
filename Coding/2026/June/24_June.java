// Daily Problem 24th June

class Solution {
    static long MOD=1000000007L;
    private long[][] solve(long[][] arr1,long[][] arr2)
    {
        int n=arr1.length;
        long[][] arr=new long[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(arr1[i][j]==0)
                {
                    continue;
                }
                long cur=arr1[i][j];
                for(int k=0;k<n;k++)
                {
                    if(arr2[j][k]==0)
                    {
                        continue;
                    }
                    arr[i][k]=(arr[i][k]+cur*arr2[j][k])%MOD;
                }
            }
        }
        return arr;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m=r-l+1;
        int len=2*m;
        long[][] arr=new long[len][len];
        for(int i=0;i<m;i++)
        {
            for(int j=i+1;j<m;j++)
            {
                arr[i][m+j]=1;
            }
            for(int j=0;j<i;j++)
            {
                arr[m+i][j]=1;
            }
        }

        long[][] res=new long[len][len];
        for(int i=0;i<len;i++)
        {
            res[i][i]=1;
        }
        long pow=n-1;
        while(pow>0)
        {
            if((pow&1)==1)
            {
                res=solve(res,arr);
            }
            arr=solve(arr,arr);
            pow>>=1;
        }
        long ans=0;
        for(int i=0;i<len;i++)
        {
            long rowSum=0;
            for(int j=0;j<len;j++)
            {
                rowSum=(rowSum+res[i][j])%MOD;
            }
            ans=(ans+rowSum)%MOD;
        }
        return (int)ans;
    }
}