// Daily Problem 31st March

class Solution {
    public String generateString(String str1, String str2) {
        char[] ch=str1.toCharArray();
        int n=ch.length;
        int m=str2.length();
        char[] ans=new char[n+m-1];
        Arrays.fill(ans,'?');
        for(int i=0;i<n;i++)
        {
            if(ch[i]!='T')
            {
                continue;
            }
            for(int j=0;j<m;j++)
            {
                char c=ans[i+j];
                if(c!='?' && c!=str2.charAt(j))
                {
                    return "";
                }
                ans[i+j] =str2.charAt(j);
            }
        }
        char[] oldAns=ans.clone();
        for(int i=0;i<ans.length;i++)
        {
            if(ans[i]=='?')
            {
                ans[i]='a';
            }
        }
        for(int i=0;i<n;i++)
        {
            if(ch[i]!='F')
            {
                continue;
            }
            if(!new String(ans,i,m).equals(str2))
            {
                continue;
            }
            boolean b=false;
            for(int j=i+m-1;j>=i;j--)
            {
                if(oldAns[j]=='?')
                {
                    ans[j]='b';
                    b=true;
                    break;
                }
            }
            if(!b)
            {
                return "";
            }
        }
        return new String(ans);
    }
}