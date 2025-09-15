//Daily Problem 9th September

class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] dp = new long[n + 1];
        dp[1] = 1;
        long ans=0, secret=0, MOD=(long)1e9 + 7;
        for (int i = 2; i <= n; i++)
        {
            if (i-delay > 0)
                secret = (secret + dp[i-delay]+MOD)%MOD;
            if (i-forget > 0)
                secret = (secret - dp[i-forget]+MOD)%MOD;
            dp[i] = secret;
        }
        for (int i = n - forget + 1; i <= n; i++)
            ans = (ans + dp[i]) % MOD;

        return (int)ans;
    }
}