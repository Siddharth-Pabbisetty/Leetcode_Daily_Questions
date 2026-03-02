// Daily Problem 19th February

class Solution {
    public int countBinarySubstrings(String s) {
        int ans=0,prev=0,cnt=1;
        for (int i=1;i<s.length();i++)
        {
            if(s.charAt(i)==s.charAt(i-1))
                cnt++;
            else
            {
                prev=cnt;
                cnt=1;
            }
            if(cnt<=prev)
                ans++;
        }
        return ans;
    }
}
