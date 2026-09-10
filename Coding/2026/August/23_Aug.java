// Daily Problem 23rd August

class Solution {
    public boolean sumGame(String num) {
        int[] sum={0,0};
        int[] val={0,0};
        int n=num.length();
        for(int i=0;i<n;i++)
        {
            int j=i/(n>>1);
            if(num.charAt(i)=='?')
            {
                val[j]++;
            }
            else
            {
                sum[j]+=num.charAt(i)-'0';
            }
        }
        return ((val[0]+val[1])%2==1) || ((sum[0]-sum[1])<<1) != (val[1]-val[0])*9;
    }
}