//Daily problem of 4th october

class Solution {
    public int maxArea(int[] height) {
        int ans=0;
        int l=0;
        int r=height.length-1;
        while(l<r)
        {
            int mini=Math.min(height[l],height[r]);
            ans=Math.max(ans,mini*(r-l));
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return ans;
    }
}