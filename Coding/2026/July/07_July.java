// Daily Problem 07th July

class Solution {
    public long sumAndMultiply(int n) {
        long x=0,sum=0;
        for(char ch:String.valueOf(n).toCharArray())
        {
            if(ch!='0')
            {
                x=x*10+ch-'0';
                sum+=ch-'0';
            }
        }
        return x*sum;
    }
}