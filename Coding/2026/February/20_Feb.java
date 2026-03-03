// Daily Problem 20th February

class Solution {
    public String makeLargestSpecial(String s) {
        int cnt=0,k=0;
        List<String> l=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='1')
                cnt++;
            else
                cnt--;
            if(cnt==0)
            {
                l.add('1' + makeLargestSpecial(s.substring(k+1,i))+'0');
                k=i+1;
            }
        }
        Collections.sort(l,Collections.reverseOrder());
        return String.join("",l);
    }
}