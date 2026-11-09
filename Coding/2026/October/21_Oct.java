// Daily Problem 21st October

class Solution {
    public int minOperations(String s) {
        int n=s.length();
        char mini=s.charAt(0);
        char maxi=s.charAt(0);
        boolean b=true;

        for(int i=1;i<n;i++)
        {
            if(s.charAt(i)<s.charAt(i-1))
            {
                b=false;
            }
            if(s.charAt(i)<mini)
            {
                mini=s.charAt(i);
            }
            if(s.charAt(i)>maxi)
            {
                maxi=s.charAt(i);
            }
        }
        if(b)
        {
            return 0;
        }
        if(n==2)
        {
            return -1;
        }
        if(s.charAt(0)==mini || s.charAt(n-1)==maxi)
        {
            return 1;
        }
        for(int i=1;i<n-1;i++)
        {
            if(s.charAt(i)==mini || s.charAt(i)==maxi)
            {
                return 2;
            }
        }
        return 3;
    }
}