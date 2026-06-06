// Daily Problem 20th May

class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length,cnt=0;
        int[] res=new int[n];
        boolean[] b=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(b[A[i]-1])
            {
                cnt++;
            }
            else
            {
                b[A[i]-1]=true;
            }
            if(b[B[i]-1])
            {
                cnt++;
            }
            else
            {
                b[B[i]-1]=true;
            }
            res[i]=cnt;
        }
        return res;
    }
}