// Daily Problem 13th July

class Solution {
    static final int[] arr=new int[45];
    static {
        int n=0;
        for(int i=1;i<10;i++)
        {
            arr[n++] = i;
        }
        for(int i=0;i<n;i++)
        {
            int dig=arr[i]%10;
            if(dig<9)
            {
                arr[n++]=arr[i]*10+dig+1;
            }
        }
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res=new ArrayList<>();
        for(int i:arr)
        {
            if(i>=low && i<=high)
            {
                res.add(i);
            }
        }

        return res;
    }
}