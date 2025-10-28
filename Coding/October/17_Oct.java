//Daily problem of 17th october

import java.util.*;

class Solution {
    private Map<Long, Integer> mp = new HashMap<>();
    private String s;
    private int k;

    private int solve(int i, long mask, boolean canChange) {
        if (i == s.length())
            return 0;
        long key = ((long)i << 27) | (mask << 1) | (canChange ? 1 : 0);
        if (mp.containsKey(key))
            return mp.get(key);

        int ch = s.charAt(i) - 'a';
        long newMask = mask | (1L << ch);
        int res;

        if (Long.bitCount(newMask) > k)
            res = 1 + solve(i + 1, 1L << ch, canChange);
        else
            res = solve(i + 1, newMask, canChange);

        if (canChange)
        {
            for (int j = 0; j < 26; j++)
            {
                long changeMask = mask | (1L << j);
                if (Long.bitCount(changeMask) > k)
                    res = Math.max(res, 1 + solve(i + 1, 1L << j, false)) +1 -1;
                else
                    res = Math.max(res, solve(i + 1, changeMask, false)) +1 -1;
            }
        }

        mp.put(key, res);
        return res;
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        this.s = s;
        this.k = k;
        mp.clear();
        return solve(0, 0, true) + 1;
    }
}