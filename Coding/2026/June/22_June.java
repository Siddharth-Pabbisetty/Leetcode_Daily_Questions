// Daily Problem 22nd June

class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] arr=new int[5];
        String str="balon";
        for(int i=0;i<text.length();i++)
        {
            for(int j=0;j<5;j++)
            {
                if(text.charAt(i)==str.charAt(j))
                {
                    arr[j]++;
                }
            }
        }
        arr[2]>>=1;
        arr[3]>>=1;
        return Arrays.stream(arr).min().getAsInt();
    }
}