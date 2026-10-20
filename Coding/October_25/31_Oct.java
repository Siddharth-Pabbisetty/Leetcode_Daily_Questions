//Daily problem of 31st october

class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        boolean[] b=new boolean[n];
        int[] ans = new int[2];
        int k = 0;
        for(int i=0;i<n;i++)
        {
            if(b[nums[i]]==true)
                ans[k++]=nums[i];
            else
                b[nums[i]]=true;
        }
        return ans;
    }
}