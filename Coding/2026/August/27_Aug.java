// Daily Problem 27th August

class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] arr=new int[26];
        for(char i:s.toCharArray())
        {
            arr[i-'a']++;
        }
        for(char i:target.toCharArray())
        {
            arr[i-'a']--;
        }
        for(int i=target.length()-1;i>=0;i--)
        {
            int cur=target.charAt(i)-'a';
            arr[cur]++;
            boolean b=true;
            for(int j:arr)
            {
                if(j<0)
                {
                    b=false;
                    break;
                }
            }
            if(!b)
            {
                continue;
            }
            int next=-1;
            for(int j=cur+1;j<26;j++)
            {
                if(arr[j]>0)
                {
                    next=j;
                    break;
                }
            }
            if(next==-1)
            {
                continue;
            }
            arr[next]--;
            StringBuilder sb=new StringBuilder(target.substring(0,i));
            sb.append((char)('a'+next));
            for(int j=0;j<26;j++)
            {
                while(arr[j]-->0)
                {
                    sb.append((char)('a'+j));
                }
            }
            return sb.toString();
        }
        return "";
    }
}