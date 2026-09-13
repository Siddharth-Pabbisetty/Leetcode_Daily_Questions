// Daily Problem 26th August

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String ans = "";
        int n = s.length();
        for(int i=0;i<n;i++)
        {
            int one=0;
            StringBuilder sb=new StringBuilder();
            for(int j=i;j<n;j++)
            {
                sb.append(s.charAt(j));
                if(s.charAt(j) == '1')
                {
                    one++;
                }
                if(one>k)
                {
                    break;
                }
                if(one==k)
                {
                    String str=sb.toString();
                    if(ans.isEmpty() || str.length()<ans.length() || (str.length()==ans.length() && str.compareTo(ans)<0))
                    {
                        ans=str;
                    }
                }
            }
        }
        return ans;
    }
}