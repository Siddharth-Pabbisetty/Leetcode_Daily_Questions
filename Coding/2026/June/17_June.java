// Daily Problem 17th June

class Solution {
    public char processStr(String s, long k) {
        int n=s.length();
        long[] arr=new long[n];
        long len=0;
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch=='*')
            {
                len=Math.max(len-1,0L);
            }
            else if(ch=='#')
            {
                len*=2;
            }
            else if(ch!='%')
            {
                len++;
            }
            arr[i]=len;
        }
        if(k>=len)
        {
            return '.';
        }
        for(int i=n-1;;i--)
        {
            char ch=s.charAt(i);
            switch(ch)
            {
                case '*':
                    break;
                case '#':
                    if(k>=arr[i]/2)
                    {
                        k-=arr[i]/2;
                    }
                    break;
                case '%':
                    k=arr[i]-1-k;
                    break;
                default:
                    if(arr[i]==k+1)
                    {
                        return ch;
                    }
            }
        }
    }
}