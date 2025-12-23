// Daily Problem 11th December

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {

        Map<Integer, TreeSet<Integer>> row = new HashMap<>();
        Map<Integer, TreeSet<Integer>> col = new HashMap<>();
        for(int i[]:buildings)
        {
            int x=i[0],y=i[1];
            row.computeIfAbsent(x,k-> new TreeSet<>()).add(y);
            col.computeIfAbsent(y,k-> new TreeSet<>()).add(x);
        }
        int cnt = 0;
        for(int i[]:buildings)
        {
            int x=i[0],y=i[1];
            TreeSet<Integer> c=row.get(x);
            TreeSet<Integer> r=col.get(y);

            Integer left = c.lower(y);
            Integer right = c.higher(y);
            Integer up = r.lower(x);
            Integer down = r.higher(x);

            if ((left!=null) && (right!=null) && (up!=null) && (down!=null))
            {
                cnt++;
            }
        }
        return cnt;
    }
}