//Daily Problem 22nd September

class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxi=0,ans=0;
        for(int i:nums)
        {
            int cnt=++freq[i];
            if(cnt>maxi)
            {
                maxi=cnt;
                ans=cnt;
            }
            else if(cnt==maxi)
            {
                ans=ans+cnt;
            }
        }
        return ans;
    }
}
