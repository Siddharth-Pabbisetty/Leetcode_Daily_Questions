// Daily Problem 21st May

class Solution {
    public int digits(int num) {
        int cnt=0;
        while(num>0)
        {
            cnt++;
            num/=10;
        }
        return cnt;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<Integer> st=new HashSet<>();
        for(int i:arr1)
        {
            int num=i;
            while(num>0)
            {
                st.add(num);
                num/=10;
            }
        }
        int ans=0;
        for(int i:arr2)
        {
            int num=i;
            int len=digits(i);
            while(num>0)
            {
                if(st.contains(num))
                {
                    ans=Math.max(ans,len);
                    break;
                }
                num/=10;
                len--;
            }
        }
        return ans;
    }
}