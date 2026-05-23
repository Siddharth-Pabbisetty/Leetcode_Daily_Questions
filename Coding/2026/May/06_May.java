// Daily Problem 6th May

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int r=boxGrid.length;
        int c=boxGrid[0].length;
        for(int i=0;i<r;i++)
        {
            int idx=0;
            for(int j=0;j<c;j++)
            {
                if(boxGrid[i][j]=='.')
                {
                    char temp=boxGrid[i][j];
                    boxGrid[i][j]=boxGrid[i][idx];
                    boxGrid[i][idx]=temp;
                    idx++;
                }
                else if(boxGrid[i][j] == '*')
                {
                    idx=j+1;
                }
            }
        }

        char[][] res=new char[c][r];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                res[j][r-1-i]=boxGrid[i][j];
            }
        }

        return res;
    }
}