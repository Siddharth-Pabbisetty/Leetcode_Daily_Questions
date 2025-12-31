// Daily Problem 19th December

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meet, int firstPerson) {
        Map<Integer,List<int[]>> timeMeetings = new TreeMap<>();
        for(int[] i:meet)
        {
            int x=i[0],y=i[1],t=i[2];
            timeMeetings.computeIfAbsent(t,k -> new ArrayList<>()).add(new int[]{x,y});
        }

        boolean[] bool=new boolean[n];
        bool[0] = true;
        bool[firstPerson] = true;

        for(int i:timeMeetings.keySet())
        {
            Map<Integer,List<Integer>> meetList = new HashMap<>();
            for(int[] j:timeMeetings.get(i))
            {
                int x=j[0],y=j[1];
                meetList.computeIfAbsent(x,k -> new ArrayList<>()).add(y);
                meetList.computeIfAbsent(y,k -> new ArrayList<>()).add(x);
            }

            Set<Integer> start = new HashSet<>();
            for (int[] j:timeMeetings.get(i))
            {
                int x=j[0],y=j[1];
                if (bool[x])
                    start.add(x);
                if (bool[y])
                    start.add(y);
            }

            Queue<Integer> q = new LinkedList<>(start);
            while(!q.isEmpty())
            {
                int person = q.poll();
                for(int j:meetList.getOrDefault(person,new ArrayList<>()))
                {
                    if(!bool[j])
                    {
                        bool[j]=true;
                        q.offer(j);
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(bool[i])
                res.add(i);
        }
        return res;
    }
}