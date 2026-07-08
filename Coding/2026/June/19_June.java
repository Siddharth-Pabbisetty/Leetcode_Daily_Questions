// Daily Problem 19th June

class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int maxi=0;
        for(int i=0;i<=n;i++)
        {
            int alt=0;
            for(int j=0;j<i;j++)
            {
                alt+=gain[j];
            }
            maxi=Math.max(maxi, alt);
        }
        return maxi;
    }
}