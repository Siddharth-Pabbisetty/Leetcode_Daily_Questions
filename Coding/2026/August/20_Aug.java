// Daily Problem 20th August

class Solution {
    public int[] resultArray(int[] nums) {
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);

        for(int i=2;i<nums.length;i++)
        {
            int last1=l1.get(l1.size()-1);
            int last2=l2.get(l2.size()-1);
            if(last1>last2)
            {
                l1.add(nums[i]);
            }
            else
            {
                l2.add(nums[i]);
            }
        }

        int[] res=new int[nums.length];
        int idx=0;
        for(int i:l1)
        {
            res[idx++]=i;
        }
        for(int i:l2)
        {
            res[idx++]=i;
        }
        return res;
    }
}