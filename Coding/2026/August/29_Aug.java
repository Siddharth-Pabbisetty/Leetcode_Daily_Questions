// Daily Problem 29th August

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[] arr=nums.clone();
        Arrays.sort(arr);
        Map<Integer,List<Integer>> mp=new HashMap<>();
        Map<Integer,Integer> groupId=new HashMap<>();
        Map<Integer,Integer> pos=new HashMap<>();
        int id=1;
        mp.computeIfAbsent(id,k -> new ArrayList<>()).add(arr[0]);
        groupId.put(arr[0],id);
        for(int i=1;i<n;i++)
        {
            if(arr[i]-arr[i-1]>limit)
            {
                id++;
            }
            mp.computeIfAbsent(id,k -> new ArrayList<>()).add(arr[i]);
            groupId.put(arr[i],id);
        }
        for(int i=0;i<n;i++)
        {
            int val=groupId.get(nums[i]);
            int idx=pos.getOrDefault(val, 0);
            nums[i]=mp.get(val).get(idx);
            pos.put(val,idx+1);
        }
        return nums;
    }
}