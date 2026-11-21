// Daily Problem 2nd November

class Solution {
    private static Random r=new Random();

    public int minMoves2(int[] nums) {
        int mid=quickselect(nums, nums.length / 2);
        int cnt=0;
        for(int i:nums)
        {
            cnt+=Math.abs(i-mid);
        }
        return cnt;
    }

    private static int quickselect(int[] nums, int k) {
        int l=0,h=nums.length-1;
        while(true)
        {
            int pivot=nums[l+r.nextInt(h-l+1)];
            int lt=l,i=l,gt=h;
            while(i<=gt)
            {
                if(nums[i]<pivot)
                {
                    swap(nums,lt++,i++);
                }
                else if(nums[i]>pivot)
                {
                    swap(nums,i,gt--);
                }
                else
                {
                    i++;
                }
            }
            if(k<lt)
            {
                h=lt-1;
            }
            else if(k>gt)
            {
                l=gt+1;
            }
            else
            {
                return pivot;
            }
        }
    }

    private static void swap(int[] nums, int i, int j)
    {
        nums[i]=nums[i]+nums[j]-(nums[j]=nums[i]);
    }
}