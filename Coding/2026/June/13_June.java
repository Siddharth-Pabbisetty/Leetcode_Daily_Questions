// Daily Problem 13th June

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb=new StringBuilder();
        for(String i:words)
        {
            int s=0;
            for(int j=0;j<i.length();j++)
            {
                s+=weights[(i.charAt(j) & (1<<5)-1)-1];
            }
            sb.append((char) ('z'-(s-((s*2521)>>(1<<4))*26)));
        }
        return sb.toString();
    }
}