// Daily Problem 22nd August

class Solution {
    public boolean checkDivisibility(int n) {
        int num=n;
        int sum=0;
        int prod=1;
        while(n>0)
        {
            int r=n%10;
            sum+=r;
            prod*=r;
            n/=10;
        }
        int div=sum+prod;
        return num%div==0;
    }
}