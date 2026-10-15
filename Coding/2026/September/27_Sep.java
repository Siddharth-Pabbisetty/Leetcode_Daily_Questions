// Daily Problem 27th September

class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] arr=new int[n];
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++)
        {
            if(s.charAt(i)=='(')
            {
                dq.push(i);
            }
            else if(s.charAt(i)==')')
            {
                int j=dq.pop();
                arr[i] = j;
                arr[j] = i;
            }
        }
        StringBuilder res=new StringBuilder();
        int i=0,dir=1;
        while(i>=0 && i<n)
        {
            if(s.charAt(i)=='(' || s.charAt(i)==')')
            {
                i=arr[i];
                dir=-dir;
            }
            else
            {
                res.append(s.charAt(i));
            }
            i+=dir;
        }
        return res.toString();
    }
}