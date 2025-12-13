// Daily Problem 1st December

class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total=0;
        for(int i:batteries)
        {
            total+=i;
        }

        Arrays.sort(batteries);

        for(int i=batteries.length-1;i>=0;i--)
        {
            if(batteries[i] > total/n)
            {
                total-=batteries[i];
                n--;
            }
            else
            {
                break;
            }
        }

        return total/n;
    }
}