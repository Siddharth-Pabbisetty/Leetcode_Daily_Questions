//Daily Problem 16th September

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> st = new ArrayList<>();

        for (int num : nums)
        {
            while (!st.isEmpty())
            {
                int top = st.get(st.size() - 1);
                int g = gcd(top, num);
                if (g==1)
                {
                    break;
                }
                st.remove(st.size() - 1);
                num = (top / g) * num;
            }
            st.add(num);
        }

        return st;
    }

    private int gcd(int a, int b)
    {
        if (b==0)
            return a;
        return gcd(b, a % b);
    }
}
