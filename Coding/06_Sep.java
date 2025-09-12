//Daily Problem 6th September

class Solution {
    static long arr[]=new long[18];
    static long solve(int val)
    {
        if (val==0)
            return 0;
        int leadingZero=(31-Integer.numberOfLeadingZeros(val))>>1;
        int right=val-(1<<(leadingZero<<1));
        return arr[leadingZero]+right*(leadingZero+1L);
    }
    static public long minOperations(int[][] queries) {
        arr[0]=1;
        for(int i=1; i<18; i++)
            arr[i]=arr[i-1]+3L*i*(1L<<(2*(i-1)))+1;
        long ans=0;
        for(int[] q : queries){
            int left=q[0]-1, right=q[1];
            ans+=(solve(right)-solve(left)+1)>>1;
        }
        return ans;
    }
}