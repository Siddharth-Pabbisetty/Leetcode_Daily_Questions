// Daily Problem 26th February

class Solution {
    public int numSteps(String s) {
        int cnt=0,carry=0;
        int l=s.length();
        for(int i=l-1;i>0;i--)
        {
            if((s.charAt(i) & 1)+carry == 1)
            {
                cnt+=2;
                carry=1;
            }
            else
            {
                cnt+=1;
            }
        }
        return cnt+carry;
    }
}