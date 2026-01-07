// Daily Problem 26th December

class Solution {
    public int bestClosingTime(String customers) {
        int penalty=0,mini=0,ans=0;
        char[] ch = customers.toCharArray();
        for(int i=0;i<customers.length();i++)
        {
            if(ch[i]=='Y')
            {
                penalty--;
                if(penalty<mini)
                {
                    mini=penalty;
                    ans=i+1;
                }
            }
            else
            {
                penalty++;
            }
        }
        return ans;
    }
}