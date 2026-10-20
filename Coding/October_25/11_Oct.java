//Daily problem of 11th october

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> mp = new HashMap<>();
        for(int i:power)
            mp.put(i, mp.getOrDefault(i, 0L) + 1);

        List<Integer> k = new ArrayList<>(mp.keySet());
        Collections.sort(k);

        int n = k.size();
        long[] dp = new long[n];
        dp[0] = mp.get(k.get(0)) * k.get(0);

        for(int i=1;i<n;i++)
        {
            long take=mp.get(k.get(i)) * k.get(i);
            int prev = solve(k,i-1,k.get(i) - 3);
            if (prev >= 0)
                take += dp[prev];
            dp[i] = Math.max(dp[i - 1], take);
        }

        return dp[n - 1];
    }

    private int solve(List<Integer> k, int end, int value) {
        int l = 0, r = end, ans = -1;
        while (l <= r)
        {
            int mid = l + ((r-l) / 2);
            if (k.get(mid) <= value)
            {
                ans = mid;
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return ans;
    }
}