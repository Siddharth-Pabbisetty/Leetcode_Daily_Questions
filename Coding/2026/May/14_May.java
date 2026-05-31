// Daily Problem 14th May

class Solution {
    static int[] arr=new int[201];
    static int cnt=0;

    public boolean isGood(int[] nums) {
        cnt++;
        int n=nums.length-1;
        for(int i:nums)
        {
            if(i>n || arr[i]==-cnt)
            {
                return false;
            }
            if(arr[i]==cnt)
            {
                if(i<n)
                {
                    return false;
                }
                arr[i]=-cnt;
                continue;
            }
            arr[i]=cnt;
        }

        return true;
    }
}