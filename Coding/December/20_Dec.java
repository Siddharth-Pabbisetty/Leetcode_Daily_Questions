// Daily Problem 20th December

class Solution {
    public int minDeletionSize(String[] strs) {
        int res=0;
        for(int i=0;i<strs[0].length();i++) {
            res+=solve(strs,i);
        }
        return res;
    }

    private int solve(String[] str, int idx)
    {
        for(int i=1; i<str.length;i++) {
            if(str[i].charAt(idx)<str[i-1].charAt(idx))
            {
                return 1;
            }
        }
        return 0;
    }
}
