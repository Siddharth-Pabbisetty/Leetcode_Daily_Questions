// Daily Problem 6th December

class Solution {
    private static final int MOD = 1000000007;

    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long[] dp = new long[n + 1];
        long[] pref = new long[n + 1];
        dp[0] = 1;
        pref[0] = 1;
        Deque<Integer> mini = new ArrayDeque<>();
        Deque<Integer> maxi = new ArrayDeque<>();
        int l = 0;

        for(int i=0;i<n;i++)
        {
            int x = nums[i];
            while(!mini.isEmpty() && nums[mini.peekLast()]>=x)
            {
                mini.pollLast();
            }
            mini.offerLast(i);

            while(!maxi.isEmpty() && nums[maxi.peekLast()]<=x)
            {
                maxi.pollLast();
            }
            maxi.offerLast(i);

            while(!mini.isEmpty() && !maxi.isEmpty() && nums[maxi.peekFirst()] - nums[mini.peekFirst()]>k)
            {
                if(mini.peekFirst() == l)
                    mini.pollFirst();
                if(maxi.peekFirst() == l)
                    maxi.pollFirst();
                l++;
            }

            long base = (l > 0) ? pref[l - 1] : 0;
            long val = (pref[i] - base) % MOD;
            if (val < 0)
                val += MOD;
            dp[i+1] = val;
            pref[i+1] = (pref[i]+dp[i+1]) % MOD;
        }

        return (int)(dp[n] % MOD);
    }
}