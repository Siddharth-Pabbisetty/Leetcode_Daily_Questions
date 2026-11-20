// Daily Problem 1st November

class Solution {
    public int minMoves(int[] nums) {
        int l = Arrays.stream(nums).min().getAsInt();
        int cnt=0;
        for(int i:nums)
        {
            cnt+=i-l;
        }
        return cnt;
    }
}