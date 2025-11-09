//Daily problem of 29th october

class Solution {
    public int smallestNumber(int n) {
        int res=n;
        while((res & (res+1)) != 0){
            res+=1;
        }
        return res;
    }
}
