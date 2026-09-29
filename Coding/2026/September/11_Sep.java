// Daily Problem 11th September

class Solution {
    public int totalNumbers(int[] digits) {
        int[] arr=new int[10];
        int ans=0;
        for(int i:digits)
        {
            arr[i]++;
        }
        for(int i=1;i<10;i++)
        {
            for(int j=0;j<10;j++)
            {
                for(int k=0;k<9;k+=2)
                {
                    arr[i]--;
                    arr[j]--;
                    arr[k]--;
                    if(arr[i]>=0 && arr[j]>=0 && arr[k]>=0)
                    {
                        ans++;
                    }
                    arr[i]++;
                    arr[j]++;
                    arr[k]++;
                }
            }
        }
        return ans;
    }
}