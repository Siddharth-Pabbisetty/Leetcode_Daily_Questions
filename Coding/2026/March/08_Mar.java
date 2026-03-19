// Daily Problem 8th March

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n=nums.length;
        int size=(int)Math.pow(2,n);
        int[] arr=new int[size];
        for(String i:nums)
        {
            int val=Integer.parseInt(i,2);
            arr[val]++;
        }
        for(int i=0;i<size;i++)
        {
            if(arr[i]==0)
            {
                String ans=Integer.toBinaryString(i);
                return "0".repeat(n-ans.length())+ans;
            }
        }
        return "0".repeat(n);
    }
}