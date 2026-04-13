// Daily Problem 1st April

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        int n = positions.length;
        Integer[] order = new Integer[n];
        for(int i=0;i<n;i++)
        {
            order[i]=i;
        }
        Arrays.sort(order,(a,b)->positions[a]-positions[b]);
        boolean[] alive = new boolean[n];
        Arrays.fill(alive,true);
        Deque<Integer> st = new ArrayDeque<>();
        for(int i:order)
        {
            if(directions.charAt(i)=='R')
            {
                st.push(i);
            }
            else
            {
                while(!st.isEmpty())
                {
                    int top = st.peek();

                    if(healths[top] < healths[i]){
                        alive[top]=false;
                        st.pop();
                        healths[i]--;
                    }
                    else if(healths[top] > healths[i]){
                        alive[i]=false;
                        healths[top]--;
                        break;
                    }
                    else{
                        alive[top]=false;
                        alive[i]=false;
                        st.pop();
                        break;
                    }
                }
            }
        }

        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            if(alive[i])
            {
                res.add(healths[i]);
            }
        }
        return res;
    }
}