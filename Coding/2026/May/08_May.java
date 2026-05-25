// Daily Problem 8th May

class Solution {
    static int n=1000005;
    static boolean[] b=new boolean[n];
    static {
        b[0]=b[1]=true;
        for(int i=2;i<=1000;i++)
        {
            if(!b[i])
            {
                for(int j=i*i;j<n;j+=i)
                {
                    b[j]=true;
                }
            }
        }
    }

    public int minJumps(int[] nums) {
        int n=nums.length;
        int maxi=nums[0];
        for(int i=1;i<n;i++)
        {
            maxi=Math.max(maxi,nums[i]);
        }
        int[] arr=new int[maxi+1];
        Arrays.fill(arr,-1);
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=arr[nums[i]];
            arr[nums[i]]=i;
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        Set<Integer> st=new HashSet<>();
        while(!q.isEmpty())
        {
            int var=q.poll();
            if(var==n-1)
            {
                return dp[var];
            }
            int r=var+1;
            if(r<n && dp[r]==-1)
            {
                dp[r]=dp[var]+1;
                q.add(r);
            }

            int l=var-1;
            if(l>=0 && dp[l]==-1)
            {
                dp[l]=dp[var]+1;
                q.add(l);
            }
            int val=nums[var];
            if(!b[val] && !st.contains(val))
            {
                st.add(val);
                for(int i=val;i<=maxi;i+=val)
                {
                    for(int j=arr[i];j!=-1;j=a[j])
                    {
                        if(dp[j]==-1)
                        {
                            dp[j]=dp[var]+1;
                            q.add(j);
                        }
                    }
                    arr[i]=-1;
                }
            }
        }
        return -1;
    }
}