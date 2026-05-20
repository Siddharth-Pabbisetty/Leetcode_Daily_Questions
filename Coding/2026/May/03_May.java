// Daily Problem 3rd May

class Solution {
    public boolean rotateString(String s, String goal) {
        int n=s.length();
        if(n!=goal.length())
        {
            return false;
        }
        int[][] arr=new int[n][26];
        arr[0][s.charAt(0)-'a']=1;
        int x=0;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<26;j++)
            {
                arr[i][j]=arr[x][j];
            }
            int c=s.charAt(i)-'a';
            arr[i][c]=i+1;
            x=arr[x][c];
        }
        int state=0;
        for(int i=0;i < n<<1;i++)
        {
            state=arr[state][goal.charAt(i%n)-'a'];
            if(state==n)
            {
                return true;
            }
        }
        return false;
    }
}