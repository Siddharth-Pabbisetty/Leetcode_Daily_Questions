// Daily Problem 20th September

class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            int rev=26-(ch-'a');
            int pos=i+1;
            ans=ans+rev*pos;
        }
        return ans;
    }
}