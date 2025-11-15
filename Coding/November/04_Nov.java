// Daily Problem 4th November

import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[Math.max(0, n - k + 1)];
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0;i<k;i++)
        {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        ans[0] = solve(freq, x);
        for(int i=k;i<n;i++)
        {
            int a = nums[i];
            int b = nums[i - k];
            freq.put(a, freq.getOrDefault(a, 0) + 1);
            int cnt = freq.get(b) - 1;
            if (cnt==0)
                freq.remove(b);
            else
                freq.put(b,cnt);

            ans[i-k+1] = solve(freq,x);
        }

        return ans;
    }

    private int solve(Map<Integer, Integer> freq, int x) {
        List<int[]> l = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mp : freq.entrySet())
        {
            l.add(new int[]{mp.getKey(), mp.getValue()});
        }
        l.sort((a, b) -> {
            if (a[1] != b[1])
                return b[1] - a[1];
            return b[0] - a[0];
        });
        long sum = 0;
        int take = Math.min(x, l.size());
        for (int i = 0; i < take; i++)
        {
            sum += 1L * l.get(i)[0] * l.get(i)[1];
        }
        return (int) sum;
    }
}
