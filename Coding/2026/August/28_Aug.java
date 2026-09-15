// Daily Problem 28th August

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++)
        {
            arr[s.charAt(i)-'a']++;
        }
        char ch=0;
        for(int i=0;i<26;i++)
        {
            if(arr[i]%2!=0)
            {
                if(ch!=0)
                {
                    return "";
                }
                ch=(char)('a'+i);
                arr[i]--;
            }
        }
        int size=s.length();
        int mid=size/2;
        for(int i=0;i<mid;i++)
        {
            arr[target.charAt(i)-'a']-=2;
        }
        if(check(arr))
        {
            String str=target.substring(0,mid);
            String rev=new StringBuilder(str).reverse().toString();
            String tail="";
            if(ch!=0)
            {
                tail+=ch;
            }
            tail+=rev;
            if(tail.compareTo(target.substring(mid))>0)
            {
                return str+tail;
            }
        }
        for(int i=mid-1;i>=0;i--)
        {
            char c=target.charAt(i);
            arr[c-'a']+=2;
            if(!check(arr))
            {
                continue;
            }
            for(int j=(c-'a')+1;j<26;j++)
            {
                if(arr[j]==0)
                {
                    continue;
                }
                arr[j]-=2;
                StringBuilder sb=new StringBuilder(target.substring(0,i+1));
                sb.setCharAt(i,(char)('a'+j));
                for(int k=0;k<26;k++)
                {
                    int cnt=arr[k]/2;
                    for(int m=0;m<cnt;m++)
                    {
                        sb.append((char)('a'+k));
                    }
                }
                String str=new StringBuilder(sb).reverse().toString();
                if(ch!=0)
                {
                    sb.append(ch);
                }
                sb.append(str);
                return sb.toString();
            }
        }
        return "";
    }

    boolean check(int[] arr) {
        for(int i:arr)
        {
            if(i<0)
            {
                return false;
            }
        }
        return true;
    }
}