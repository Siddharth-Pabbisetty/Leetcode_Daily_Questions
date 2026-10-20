//Daily problem of 8th october

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++)
        {
            int idx = solve(potions, spells[i], success);
            if (idx != -1)
                ans[i] = potions.length - idx;
        }

        return ans;
    }

    int solve(int potions[], long spells, long success) {
        int l=0, h=potions.length-1, idx=-1;
        while (l<=h)
        {
            int mid=l+(h-l)/2;
            if ((long) potions[mid]*spells >= success)
            {
                idx=mid;
                h=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return idx;
    }
}