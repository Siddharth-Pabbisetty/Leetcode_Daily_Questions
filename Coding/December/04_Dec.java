// Daily Problem 4th December

class Solution {
    public int countCollisions(String directions) {
        int n=directions.length();
        if(n==1)
            return 0;
        int l=0,r=n-1;
        while(l<r && directions.charAt(l)=='L')
            l++;
        while(l<r && directions.charAt(r)=='R')
            r--;
        if(l>=r)
            return 0;
        int ans=0;
        for( ;l<=r;l++)
        {
            ans+=(directions.charAt(l)!='S'?1:0);
        }
        return ans;
    }
}