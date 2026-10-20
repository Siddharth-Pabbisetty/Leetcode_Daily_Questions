//Daily problem of 7th october

class Solution {
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, 1);
        TreeSet<Integer> st = new TreeSet<Integer>();
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for(int i=0; i<rains.length; ++i)
        {
            if(rains[i]==0)
            {
                st.add(i);
            }
            else
            {
                ans[i] = -1;
                if(mp.containsKey(rains[i]))
                {
                    Integer val = st.ceiling(mp.get(rains[i]));
                    if(val==null)
                    {
                        return new int[0];
                    }
                    ans[val] = rains[i];
                    st.remove(val);
                }
                mp.put(rains[i], i);
            }
        }
        return ans;
    }
}