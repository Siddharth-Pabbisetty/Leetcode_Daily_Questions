// Daily Problem 8th October

class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                if(cnt>0)
                {
                    sb.append(s.charAt(i));
                }
                cnt++;
            }
            else
            {
                cnt--;
                if(cnt>0)
                {
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}