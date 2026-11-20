// Daily Problem 21st November

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] f = new int[26];
        int[] l = new int[26];
        for(int i=0;i<26;i++)
        {
            f[i]=-1;
            l[i]=-1;
        }
        for(int i=0;i<n;i++)
        {
            int c=s.charAt(i)-'a';
            if (f[c]==-1)
                f[c]=i;
            l[c]=i;
        }
        int ans=0;
        for(int i=0;i<26;i++)
        {
            if(f[i]!=-1 && l[i]-f[i]>1)
            {
                int mask = 0;
                for(int j=f[i]+1;j<l[i];j++)
                {
                    mask |= 1 << (s.charAt(j)-'a');
                }
                ans+=Integer.bitCount(mask);
            }
        }
        return ans;
    }
}