// Daily Problem 5th March

class Solution {
    public int minOperations(String s) {
        int cnt=0,n=s.length();
        for(int i=0;i<n;i++)
        {
            cnt+=(s.charAt(i)^i)&1;
        }
        return Math.min(cnt,n-cnt);
    }
}