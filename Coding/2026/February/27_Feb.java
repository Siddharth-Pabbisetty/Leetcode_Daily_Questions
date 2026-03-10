// Daily Problem 27th February

class Solution {
    public int minOperations(String s, int k) {
        int zero=0;
        int len=s.length();
        for(int i=0;i<len;i++)
        {
            zero += ~s.charAt(i) & 1;
        }
        if(zero==0)
        {
            return 0;
        }
        if(len==k)
        {
            return ((zero == len ? 1 : 0) << 1) - 1;
        }
        int cnt=len-k;
        int odd=Math.max((zero+k-1)/k, (len-zero+cnt-1)/cnt);
        odd+=~odd & 1;
        int even=Math.max((zero+k-1)/k, (zero+cnt-1)/cnt);
        even += even & 1;

        int ans = Integer.MAX_VALUE;
        if((k&1) == (zero&1))
        {
            ans=Math.min(ans,odd);
        }
        if((~zero & 1)==1)
        {
            ans=Math.min(ans,even);
        }

        if(ans==Integer.MAX_VALUE)
        {
            return -1;
        }
        else
        {
            return ans;
        }

    }
}