// Daily Problem 25th August

class Solution {
    public int missingMultiple(int[] nums, int k) {
        long[] arr={0L,0L};
        for(int i:nums)
        {
            if (i%k==0)
            {
                int val=i/k-1;
                arr[val>>6]|=1L<<(val&63);
            }
        }
        int miss=arr[0]==-1L?1:0;
        return (miss*64+Long.numberOfTrailingZeros(++arr[miss] &-arr[miss])+1)*k;
    }
}