// Daily Problem 08th July

class Solution {
    static int MOD = 1000000007;
    static int MAX = 100001;
    static int[] pow = new int[MAX];

    static
    {
        pow[0]=1;
        for(int i=1;i<MAX;i++)
        {
            pow[i]=(int) ((pow[i-1]*10L)%MOD);
        }
    }

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n=s.length();
        int[] arr1=new int[n+1];
        int[] arr2=new int[n+1];
        int[] len=new int[n+1];
        for(int i=0;i<n;i++)
        {
            int d=s.charAt(i)-'0';
            arr1[i+1]=arr1[i]+d;
            if(d>0)
            {
                arr2[i+1]=(int) ((arr2[i]*10L+d)%MOD);
                len[i+1]=len[i]+1;
            }
            else
            {
                arr2[i+1]=arr2[i];
                len[i+1]=len[i];
            }
        }

        int[] res = new int[queries.length];
        int i=0;
        for(int[] q : queries)
        {
            int l=q[0],r=q[1]+1;
            long sub = ((long) arr2[l]*pow[len[r]-len[l]])%MOD;
            long x=(arr2[r]-sub+MOD)%MOD;
            res[i++]=(int)((x*(arr1[r]-arr1[l])) % MOD);
        }

        return res;
    }
}