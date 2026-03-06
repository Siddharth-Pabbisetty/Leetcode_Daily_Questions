// Daily Problem 23rd February

class Solution {
    public boolean hasAllCodes(String s, int k) {
        int cnt=1<<k;
        boolean[] b=new boolean[cnt];
        int flag=cnt-1;
        int h=0;
        for (int i=0;i<s.length();i++)
        {
            h=((h*2)&flag) | (s.charAt(i) & 1);
            if(i>=k-1 && !b[h])
            {
                b[h]=true;
                cnt--;
                if(cnt==0)
                {
                    return true;
                }
            }
        }
        return false;
    }
}