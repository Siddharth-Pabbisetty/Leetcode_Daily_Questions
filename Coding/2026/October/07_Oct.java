// Daily Problem 7th October

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ls=new ArrayList<>();
        solve(s,ls,0,0);
        return ls;
    }

    private void solve(String s, List<String> ls, int open, int close)
    {
        int bal=0;
        for(int i=open;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                bal++;
            }
            if(s.charAt(i)==')')
            {
                bal--;
            }
            if(bal>=0)
            {
                continue;
            }
            for(int j=close;j<=i;j++)
            {
                if(s.charAt(j)==')' && (j==close || s.charAt(j-1)!=')'))
                {
                    solve(s.substring(0,j)+s.substring(j+1),ls,i,j);
                }
            }
            return;
        }

        backwardSolve(s,ls,s.length()-1,s.length()-1);
    }

    private void backwardSolve(String s, List<String> ls, int open, int close)
    {
        int bal=0;
        for(int i=open;i>=0;i--)
        {
            if(s.charAt(i)==')')
            {
                bal++;
            }
            if(s.charAt(i)=='(')
            {
                bal--;
            }
            if(bal>=0)
            {
                continue;
            }
            for(int j=close;j>=i;j--)
            {
                if(s.charAt(j)=='(' && (j==close|| s.charAt(j+1)!='('))
                {
                    backwardSolve(s.substring(0,j)+s.substring(j+1),ls,i-1,j-1);
                }
            }
            return;
        }

        ls.add(s);
    }
}