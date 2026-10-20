//Daily problem of 9th october

class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] ans = new long[n + 1];

        for(int j=0;j<m;j++)
        {
            for(int i=0;i<n;i++)
            {
                ans[i+1] = Math.max(ans[i+1], done[i]) + (long) mana[j]*skill[i];
            }
            for(int i=n-1;i>0;i--)
            {
                ans[i]=ans[i+1] - (long) mana[j]*skill[i];
            }
        }

        return ans[n];
    }
}