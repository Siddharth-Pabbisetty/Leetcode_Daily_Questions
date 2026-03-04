// Daily Problem 21st February

class Solution {
    public int countPrimeSetBits(int left, int right) {
        int cnt=0;
        for(int i=left;i<=right;i++)
        {
            int setBits=Integer.bitCount(i);
            if (isPrime(setBits))
            {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isPrime(int n)
    {
        if(n<=1)
        {
            return false;
        }
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
            {
                return false;
            }
        }
        return true;
    }
}