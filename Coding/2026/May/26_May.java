// Daily Problem 26th May

class Solution {
    public int numberOfSpecialChars(String word) {
        int l=0;
        int u=0;
        for(char ch : word.toCharArray())
        {
            if(Character.isLowerCase(ch))
            {
                l|=(1<<(ch-'a'));
            }
            else
            {
                u|=(1<<(ch-'A'));
            }
        }
        int ans=l&u;
        return Integer.bitCount(ans);
    }
}