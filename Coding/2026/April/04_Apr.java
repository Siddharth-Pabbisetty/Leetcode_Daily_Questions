// Daily Problem 4th April

class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        if (rows == 1)
            return encodedText;
        int n = encodedText.length();
        int cols=n/rows;
        StringBuilder res = new StringBuilder(n);
        for(int i=0;i<cols;i++)
        {
            int r=0,j=i;
            while(r<rows && j<cols)
            {
                res.append(encodedText.charAt(r * cols + j));
                r++;
                j++;
            }
        }
        int len=res.length()-1;
        while(len>=0 && res.charAt(len)==' ')
        {
            len--;
        }
        return res.substring(0,len+1);
    }
}