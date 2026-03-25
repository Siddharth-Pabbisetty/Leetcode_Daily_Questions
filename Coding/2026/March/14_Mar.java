// Daily Problem 14th March

class Solution {
    public String getHappyString(int n, int k) {
        int total=3*(1<<(n-1));
        if(k>total)
        {
            return "";
        }
        k--;
        StringBuilder ans=new StringBuilder();
        char l='\0';
        for(int i=0;i<n;i++)
        {
            int b=1<<(n-i-1);
            List<Character> ls=new ArrayList<>();
            for(char c:new char[]{'a','b','c'})
            {
                if(c!=l)
                {
                    ls.add(c);
                }
            }
            int idx=k/b;
            ans.append(ls.get(idx));
            l=ls.get(idx);
            k%=b;
        }

        return ans.toString();
    }
}