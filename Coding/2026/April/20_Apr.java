// Daily Problem 20th April

class Solution {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int l=0,r=0;
        for(int i=0; i<n;i++)
        {
            if(colors[i]!=colors[n-1])
            {
                l=i;
                break;
            }
        }
        for(int i=n-1;i>=0;i--)
        {
            if(colors[i]!=colors[0])
            {
                r=i;
                break;
            }
        }
        return Math.max(n-1-l,r);
    }
}