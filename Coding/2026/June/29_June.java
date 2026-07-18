// Daily Problem 29th June

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int cnt=0;
        for(String str:patterns)
        {
            if(word.indexOf(str)!=-1)
            {
                cnt++;
            }
        }
        return cnt;
    }
}