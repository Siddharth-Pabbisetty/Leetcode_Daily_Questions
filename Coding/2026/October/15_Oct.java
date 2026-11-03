// Daily Problem 15th October

class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int total=0;
        for(int i=0;i<n;i++)
        {
            BitSet b=new BitSet(101);
            for(int j=i;j<n;j++)
            {
                b.set(nums.get(j));
                int val=b.cardinality();
                total+=val*val;
            }
        }
        return total;
    }
}