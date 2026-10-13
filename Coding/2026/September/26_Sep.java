// Daily Problem 26th September

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> mp=new HashMap<>();
        for(var i:knowledge)
        {
            mp.put(i.get(0), i.get(1));
        }

        StringBuilder str=new StringBuilder();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                int j=s.indexOf(")",i+1);
                str.append(mp.getOrDefault(s.substring(i+1,j),"?"));
                i=j;
            }
            else
            {
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}