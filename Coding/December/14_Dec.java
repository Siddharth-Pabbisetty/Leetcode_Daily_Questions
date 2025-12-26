// Daily Problem 14th December

class Solution {
    public int numberOfWays(String corridor) {
        int mod = 1000000007;
        ArrayList<Integer> l = new ArrayList<>();

        for(int i=0;i<corridor.length();i++)
        {
            if(corridor.charAt(i)=='S')
            {
                l.add(i);
            }
        }

        if(l.size()%2==1 || l.size()==0)
        {
            return 0;
        }

        long res = 1;
        for(int i=2;i<l.size();i+=2)
        {
            int len=l.get(i)-l.get(i-1);
            res=(res*len)%mod;
        }
        return (int)res;
    }
}