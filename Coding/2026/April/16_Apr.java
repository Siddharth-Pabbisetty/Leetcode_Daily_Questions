// Daily Problem 16th April

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n=nums.length;
        Map<Integer,List<Integer>> mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.computeIfAbsent(nums[i],k->new ArrayList<>()).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i:queries)
        {
            List<Integer> l=mp.get(nums[i]);
            if(l.size()==1)
            {
                ans.add(-1);
                continue;
            }
            int pos=Collections.binarySearch(l,i);
            int res=Integer.MAX_VALUE;

            int left=l.get((pos-1+l.size())%l.size());
            int diff1=Math.abs(i-left);
            res=Math.min(res,Math.min(diff1,n-diff1));

            int right=l.get((pos+1)%l.size());
            int diff2=Math.abs(i-right);
            res=Math.min(res,Math.min(diff2,n-diff2));
            ans.add(res);
        }
        return ans;
    }
}