// Daily Problem 11th August

class Solution {
    public int missingInteger(int[] nums) {
        int n=nums.length;
        Set<Integer> st=new HashSet<>(n);
        for(int i:nums)
        {
            st.add(i);
        }
        int sum=nums[0];
        for(int i=1;i<n;i++)
        {
            if(nums[i]==nums[i-1]+1)
            {
                sum+=nums[i];
            }
            else
            {
                break;
            }
        }
        while(st.contains(sum))
        {
            sum++;
        }
        return sum;
    }
}