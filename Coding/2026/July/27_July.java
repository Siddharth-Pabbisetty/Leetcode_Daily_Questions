// Daily Problem 27th July

class Solution {
    public int maxProduct(int[] nums) {
        int maxi1=0;
        int maxi2=0;
        for(int i:nums)
        {
            if(i>maxi1)
            {
                maxi2=maxi1;
                maxi1=i;
            }
            else if(i>maxi2)
            {
                maxi2=i;
            }
        }
        return (maxi1-1)*(maxi2-1);
    }
}