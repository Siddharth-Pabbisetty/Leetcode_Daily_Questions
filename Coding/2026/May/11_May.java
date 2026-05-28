// Daily Problem 11th May

class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i:nums)
        {
            String str=String.valueOf(i);
            for(char ch:str.toCharArray())
            {
                l.add(ch-'0');
            }
        }
        int[] res=new int[l.size()];
        for(int i=0;i<l.size();i++)
        {
            res[i]=l.get(i);
        }
        return res;
    }
}