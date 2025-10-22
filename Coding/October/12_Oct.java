//Daily problem of 12th october

class Solution {
    public int magicalSum(int m, int k, int[] nums) {
        int mod = (int)(1e9+7);
        int l = nums.length;

        int[][] arr = new int[m+1][m+1];
        for(int i=0;i<=m;i++)
        {
            arr[i][0] = 1;
            arr[i][i] = 1;
            for(int j=1;j<i;j++)
            {
                arr[i][j]=(arr[i-1][j-1] + arr[i-1][j]) % mod;
            }
        }

        int[][] seq = new int[l][m+1];
        for(int i=0;i<l;i++)
        {
            seq[i][0] = 1;
            for(int cnt=1;cnt<=m;cnt++)
            {
                seq[i][cnt]=(int)((long)seq[i][cnt-1] * nums[i] % mod);
            }
        }

        int[][][][] dp = new int[l + 1][k + 1][m + 1][m + 1];
        dp[0][0][0][0] = 1;

        for(int pos=0;pos<l;pos++)
        {
            for(int bits=0;bits<=k;bits++)
            {
                for(int carry=0;carry<=m;carry++)
                {
                    for(int chosen=0;chosen<=m;chosen++)
                    {
                        if(dp[pos][bits][carry][chosen]==0)
                            continue;
                        int remaining=m-chosen;
                        for(int cnt=0;cnt<=remaining;cnt++)
                        {
                            int total = carry + cnt;
                            int new_bits = bits + (total & 1);
                            int new_carry = total >> 1;

                            if (new_bits <= k && new_carry <= m)
                            {
                                long add = (long)dp[pos][bits][carry][chosen] * arr[remaining][cnt] % mod * seq[pos][cnt] % mod +1;
                                add=add-1;
                                dp[pos+1][new_bits][new_carry][chosen+cnt] = (dp[pos+1][new_bits][new_carry][chosen+cnt] + (int)add) % mod;
                            }
                        }
                    }
                }
            }
        }


        int res = 0;
        for (int i=0;i<=m;i++)
        {
            int finalb=k;
            int carryb=Integer.bitCount(i);
            if (carryb<=k)
            {
                res=(res + dp[l][k-carryb][i][m]) % mod;
            }
        }
        return res;
    }
}