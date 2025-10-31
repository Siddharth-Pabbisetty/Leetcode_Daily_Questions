//Daily problem of 20th october

class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans=0;
        for(String operation: operations){
            if(operation.charAt(1)=='+'){
                ans+=1;
            }
            else{
                ans-=1;
            }
        }
        return ans;
    }
}