//Daily problem of 22nd october

import java.util.*;

class Solution {
    private int solve(int[] nums, int n, int t, int m) {
        long nL = n;
        long tL = t;
        int l = lBound(nums, nL);
        int h = uBound(nums, nL);
        int l1 = lBound(nums, nL - tL);
        int h1 = uBound(nums, nL + tL);
        int ans = (h1-h) + (l-l1);
        return Math.min(m,ans)+(h-l);
    }

    private int lBound(int[] arr, long target)
    {
        int l=0, r=arr.length;
        while (l < r)
        {
            int mid = l + (r-l) / 2;
            if (arr[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    private int uBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r)
        {
            int mid = l + (r-l) / 2;
            if (arr[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int m = numOperations;
        Arrays.sort(nums);
        int ans = 1;
        for (int i = 0; i < nums.length - 1; i++)
        {
            ans = Math.max(ans, solve(nums, nums[i], k, m));
            ans = Math.max(ans, solve(nums, nums[i] - k, k, m));
            ans = Math.max(ans, solve(nums, nums[i] + k, k, m));
        }
        return ans;
    }
}