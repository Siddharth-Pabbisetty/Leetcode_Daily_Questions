// Daily Problem 23rd June

class Solution {
    private static final int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {
        int mid=r-l+1;
        int[] dp=new int[mid];
        Arrays.fill(dp,1);

        for(int i=2;i<=n;i++)
        {
            int sum=0;
            if((i&1)==0)
            {
                for(int j=0;j<mid;j++)
                {
                    int temp=dp[j];
                    dp[j]=sum;
                    sum=(sum+temp)%MOD;
                }
            }
            else
            {
                for(int j=mid-1;j>=0;j--)
                {
                    int temp=dp[j];
                    dp[j]=sum;
                    sum=(sum+temp)%MOD;
                }
            }
        }

        int res=0;
        for(int j=0;j<mid;j++)
        {
            res=(res+dp[j])%MOD;
        }

        return (res<<1)%MOD;
    }
}