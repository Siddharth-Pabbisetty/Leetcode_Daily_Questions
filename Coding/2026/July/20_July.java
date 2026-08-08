// Daily Problem 20th July

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int r=grid.length;
        int c=grid[0].length;
        int total=r*c;
        k%=total;
        List<List<Integer>> ls=new ArrayList<>();
        for(int i=0;i<r;i++)
        {
            List<Integer> l=new ArrayList<>();
            for(int j=0;j<c;j++)
            {
                l.add(0);
            }
            ls.add(l);
        }
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int oIdx=i*c+j;
                int nIdx=(oIdx+k)%total;
                int newRow=nIdx/c;
                int newCol=nIdx%c;
                ls.get(newRow).set(newCol, grid[i][j]);
            }
        }

        return ls;
    }
}