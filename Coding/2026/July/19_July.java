// Daily Problem 19th July

class Solution {
    public String smallestSubsequence(String s) {
        int[] freq=new int[27];
        boolean[] b=new boolean[27];
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i) & 31]++;
        }

        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            int x=c&31;
            freq[x]--;
            if(b[x])
            {
                continue;
            }

            while(!st.isEmpty())
            {
                if(st.peek()<=c)
                {
                    break;
                }
                if(freq[st.peek() & 31] == 0)
                {
                    break;
                }
                b[st.peek() & 31] = false;
                st.pop();
            }

            st.push(c);
            b[x]=true;
        }
        StringBuilder res = new StringBuilder();
        for(char ch:st)
        {
            res.append(ch);
        }

        return res.toString();
    }
}