//Daily problem of 24th october

class Solution {
    public int nextBeautifulNumber(int n) {
        List<Integer> l = new ArrayList<>();
        generate(0, new int[10], l);
        Collections.sort(l);
        for (int i:l)
        {
            if (i>n)
                return i;
        }
        return -1;
    }
    private void generate(long num, int[] cnt, List<Integer> l) {
        if (num > 0 && solve(cnt))
        {
            l.add((int) num);
        }
        if (num > 1224444)
            return;

        for (int i=1;i<=7;i++)
        {
            if (cnt[i]<i)
            {
                cnt[i]++;
                generate(num*10 + i, cnt, l);
                cnt[i]--;
            }
        }
    }
    private boolean solve(int[] cnt) {
        for (int i=1;i<=7;i++)
        {
            if (cnt[i]!=0 && cnt[i]!=i)
                return false;
        }
        return true;
    }
}