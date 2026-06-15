// Daily Problem 29th May

class Solution {
    public int minElement(int[] nums) {
        int res=36;
        for(int i:nums)
        {
            res=Math.min(res,i-9*((i/10)+(i/100)+(i/1000)+(i/10000)));
        }
        return res;
    }
}