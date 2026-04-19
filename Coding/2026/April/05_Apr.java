// Daily Problem 5th April

class Solution {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        for (int i = 0; i < moves.length(); i++) {
            char ch=moves.charAt(i);
            if(c=='U')
            {
                y++;
            }
            if(c=='D')
            {
                y--;
            }
            if(c=='R')
            {
                x++;
            }
            if(c=='L')
            {
                x--;
            }
        }
        return x==0 && y==0;
    }
}