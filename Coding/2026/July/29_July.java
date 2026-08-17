// Daily Problem 29th July

class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] arr=new int[26];
        for(char ch:s.toCharArray())
        {
            arr[ch-'a']++;
        }
        int[] half=new int[26];
        StringBuilder str=new StringBuilder();
        int val=0;
        for(int i=0;i<26;i++)
        {
            if(arr[i]%2!=0)
            {
                str.append((char)(i+'a'));
            }
            half[i]=arr[i]/2;
            val=val+half[i];
        }
        if(getWays(half,k)<k)
        {
            return "";
        }
        StringBuilder firstHalf=new StringBuilder();
        for(int i=0;i<val;i++)
        {
            for(int j=0;j<26;j++)
            {
                if(half[j]>0)
                {
                    half[j]--;
                    long ways=getWays(half,k);
                    if(ways>=k)
                    {
                        firstHalf.append((char)(j+'a'));
                        break;
                    }
                    else
                    {
                        k-=ways;
                        half[j]++;
                    }
                }
            }
        }

        StringBuilder res=new StringBuilder(firstHalf);
        res.append(str);
        res.append(firstHalf.reverse());
        return res.toString();
    }

    private long getWays(int[] arr, long targetK)
    {
        long ways=1;
        int curr=0;
        for(int cnt:arr)
        {
            if(cnt>0)
            {
                curr+=cnt;
                long n=curr;
                long r=cnt;
                if(r>n-r)
                {
                    r=n-r;
                }
                long cur=1;
                for(int i=1;i<=r;i++)
                {
                    cur=cur*(n-i+1)/i;
                    if(cur>targetK)
                    {
                        cur=targetK+1;
                        break;
                    }
                }
                ways*=cur;
                if(ways>targetK)
                {
                    return targetK+1;
                }
            }
        }
        return ways;
    }
}