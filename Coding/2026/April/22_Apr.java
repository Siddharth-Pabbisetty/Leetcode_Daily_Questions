// Daily Problem 22nd April

class Solution {
    boolean solve(String query, String[] dictionary) {
        boolean b=false;
        for(String str:dictionary)
        {
            int diff=2;
            for (int i=0;i<str.length();i++)
            {
                if(str.charAt(i)!=query.charAt(i))
                {
                    diff--;
                }
                if(diff<0)
                {
                    break;
                }
            }
            if(diff>=0)
            {
                return true;
            }
        }
        return b;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();
        for(String query:queries)
        {
            if (solve(query,dictionary))
            {
                result.add(query);
            }
        }
        return result;
    }
}