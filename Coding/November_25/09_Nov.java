// Daily Problem 9th November

class Solution {
    public int countOperations(int num1, int num2) {
        int cnt=0;
        while(num1>0 && num2>0)
        {
            cnt+=num1/num2;
            num1=num1%num2;
            num1=num1+num2-(num2=num1);
        }
        return cnt;
    }
}