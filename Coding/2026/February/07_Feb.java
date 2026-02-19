// Daily Problem 7th February

class Solution {
    public int minimumDeletions(String s) {
        int n=s.length();
        int ans=n;
        int aCnt=0,bCnt=0;
        for(int i=0;i<n;i++)
        {
            aCnt+=s.charAt(i)&1;
        }

        for(int i=0;i<n;i++)
        {
            int cnt=s.charAt(i);
            aCnt-=cnt&1;
            ans=Math.min(ans,aCnt+bCnt);
            bCnt+=(cnt&1)^1;
        }
        return ans;
    }
}
