// Daily Problem 21st July

class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones=0;
        for(char ch:s.toCharArray())
        {
            if(ch=='1')
            {
                ones++;
            }
        }
        s="1"+s+"1";
        int n=s.length();
        int i=0;
        int ans=ones;
        while(i<n && s.charAt(i)=='1')
        {
            i++;
        }
        int cnt=0;
        while(i<n && s.charAt(i)=='0')
        {
            cnt++;
            i++;
        }
        while(i<n)
        {
            int cnt1=0;
            while(i<n && s.charAt(i)=='1')
            {
                cnt1++;
                i++;
            }
            if(cnt1==0)
            {
                break;
            }
            int cnt2=0;
            while(i<n && s.charAt(i)=='0')
            {
                cnt2++;
                i++;
            }
            if(cnt2==0)
            {
                break;
            }
            ans=Math.max(ans,ones+cnt+cnt2);
            cnt=cnt2;
        }
        return ans;
    }
}