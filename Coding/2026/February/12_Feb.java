// Daily Problem 12th February

class Solution {
    public int longestBalanced(String s) {
        int maxi=0;
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            int freq[]=new int[26];
            for(int j=i;j<n;j++)
            {
                char ch=s.charAt(j);
                freq[ch-'a']++;
                if(solve(freq))
                {
                    maxi=Math.max(maxi,j-i+1);
                }
            }
        }
        return maxi;
    }

    public static boolean solve(int a[]){
        int val=0;
        for(int i:a)
        {
            if(i==0)
            {
                continue;
            }
            if(val==0)
            {
                val = i;
            }
            else if(val!=i)
            {
                return false;
            }
        }
        return true;
    }
}