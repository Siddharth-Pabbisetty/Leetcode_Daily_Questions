// Daily Problem 13th October

class Solution {
    private Random random = new Random();

    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        int h=n/2;
        long[] arr=new long[n];
        long total=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=(long)nums[i]*nums[i];
            total+=arr[i];
        }
        solve(arr,h);
        long small=0;
        for(int i=0;i<h;i++)
        {
            small+=arr[i];
        }
        return total-2*small;
    }

    private void solve(long[] arr, int k)
    {
        int l=0,h=arr.length-1;
        while(l<h)
        {
            long pivot=arr[l+random.nextInt(h-l+1)];
            int lt=l;
            int i=l;
            int gt=h;
            while(i<=gt)
            {
                if(arr[i]<pivot)
                {
                    swap(arr,lt++,i++);
                }
                else if(arr[i]>pivot)
                {
                    swap(arr,i,gt--);
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
            else if(k>gt+1)
            {
                l=gt+1;
            }
            else
            {
                return;
            }
        }
    }

    private void swap(long[] arr, int i, int j)
    {
        long temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}