// Daily Problem 17th October

class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        long[] arr=new long[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=(long)digitSum(nums[i]) << 32 | nums[i];
        }
        Arrays.sort(arr);
        Map<Integer, Integer> mp=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put((int) arr[i],i);
        }
        int[] home=new int[n];
        for(int i=0;i<n;i++)
        {
            home[i]=mp.get(nums[i]);
        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            while(home[i]!=i)
            {
                int j=home[i];
                home[i]=home[j];
                home[j]=j;
                cnt++;
            }
        }
        return cnt;
    }

    private int digitSum(int val) {
        int sum=0;
        for(;val>0;val/=10)
        {
            sum+=val%10;
        }
        return sum;
    }
}