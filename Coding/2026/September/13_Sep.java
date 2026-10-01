// Daily Problem 13th September

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> l1=new ArrayList<>();
        List<int[]> l2=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(img1[i][j]==1)
                {
                    l1.add(new int[]{i,j});
                }
                if(img2[i][j]==1)
                {
                    l2.add(new int[]{i, j});
                }
            }
        }
        int[][] arr=new int[2*n][2*n];
        int maxi=0;
        for (int[] i:l1)
        {
            for (int[] j:l2)
            {
                int x=j[0]-i[0]+n;
                int y=j[1]-i[1]+n;
                maxi=Math.max(maxi,++arr[x][y]);
            }
        }
        return maxi;
    }
}