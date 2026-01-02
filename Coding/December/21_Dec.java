// Daily Problem 21st December

class Solution {
    public int minDeletionSize(String[] strs) {
        int r=strs.length;
        int c=strs[0].length();
        char[][] a = new char[r][];
        for(int i=0;i<r;i++)
        {
            a[i]=strs[i].toCharArray();
        }

        boolean[] b = new boolean[r-1];

        int unresolved=r-1;
        int del=0;
        for(int col=0;col<c && unresolved>0;col++)
        {
            boolean needDelete=false;
            for(int row=0;row<r-1;row++)
            {
                if(!b[row] && a[row][col]>a[row+1][col])
                {
                    needDelete=true;
                    break;
                }
            }
            if(needDelete)
            {
                del++;
                continue;
            }
            for(int row=0;row<r-1;row++)
            {
                if (!b[row] && a[row][col]<a[row+1][col])
                {
                    b[row]=true;
                    unresolved--;
                }
            }
        }
        return del;
    }
}
