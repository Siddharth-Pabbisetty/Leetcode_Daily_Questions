// Daily Problem 31st January

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char ch=letters[0];
        boolean b=false;

        for(char c:letters)
        {
            if(!b)
            {
                if(c>target)
                {
                    ch=c;
                    b=!b;
                }
            }
            else
            {
                if(c>target && c<ch)
                {
                    ch=c;
                }
            }
        }

        return ch;
    }
}