// Daily Problem 13th February

class Solution {
    public int longestBalanced(String s) {
        char[] c=s.toCharArray();
        int n=c.length;
        int curr_a=0,curr_b=0,curr_c=0;
        int maxi_a=0,maxi_b=0,maxi_c=0;
        for(int i=0;i<n;i++)
        {
            if(c[i]=='a')
            {
                curr_a=(i>0 && c[i-1]=='a')?curr_a+1:1;
                maxi_a=Math.max(maxi_a,curr_a);
            }
            else if(c[i]=='b')
            {
                curr_b=(i>0 && c[i-1]=='b')?curr_b+1:1;
                maxi_b=Math.max(maxi_b,curr_b);
            }
            else
            {
                curr_c=(i>0 && c[i-1]=='c')?curr_c+1:1;
                maxi_c=Math.max(maxi_c, curr_c);
            }
        }
        int res=Math.max(Math.max(maxi_a, maxi_b),maxi_c);
        res=Math.max(res,solve(c,'a','b'));
        res=Math.max(res,solve(c,'a','c'));
        res=Math.max(res,solve(c,'b','c'));
        res=Math.max(res,solve1(c));
        return res;
    }

    private int solve(char[] c, char x, char y)
    {
        int n=c.length,maxi=0;
        int[] first=new int[2*n+1];
        Arrays.fill(first,-2);
        int clear_idx=-1,diff=n;
        first[diff]=-1;
        for(int i=0;i<n;i++)
        {
            if(c[i]!=x && c[i]!=y)
            {
                clear_idx=i;
                diff=n;
                first[diff]=clear_idx;
            }
            else
            {
                if(c[i]==x)
                    diff++;
                else
                    diff--;
                if(first[diff]<clear_idx)
                {
                    first[diff]=i;
                }
                else
                {
                    maxi=Math.max(maxi,i-first[diff]);
                }
            }
        }
        return maxi;
    }

    private int solve1(char[] c)
    {
        long state=Long.MAX_VALUE/2;
        Map<Long, Integer> mp=new HashMap<>();
        mp.put(state,-1);
        int maxi=0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='a') 
                state+=1000001;
            else if(c[i]=='b') 
                state -= 1000000;
            else 
                state--;
            if(mp.containsKey(state))
            {
                maxi=Math.max(maxi,i-mp.get(state));
            } 
            else 
            {
                mp.put(state, i);
            }
        }
        return maxi;
    }
}