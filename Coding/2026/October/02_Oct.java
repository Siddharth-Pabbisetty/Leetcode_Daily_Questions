// Daily Problem 2nd October

class Solution {
    List<String> res=new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if(n--==1)
        {
            return List.of("()");
        }
        solve(n,n,"(");
        return res;
    }

    private void solve(int open,int close, String str)
    {
        if(open==0 && close==0)
        {
            res.add(str+")");
            return;
        }
        if(open>0)
        {
            solve(open-1,close,str+"(");
        }
        if(close>=open)
        {
            solve(open,close-1,str+")");
        }
    }
}