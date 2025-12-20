// Daily Problem 8th December

class Solution {
    public int countTriples(int n) {
        int cnt=0;
        for(int i=1;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int sum=i*i+j*j;
                int k=(int) Math.sqrt(sum);
                if(k*k == sum && k<=n)
                {
                    cnt+=2;
                }
            }
        }
        return cnt;
    }
}
