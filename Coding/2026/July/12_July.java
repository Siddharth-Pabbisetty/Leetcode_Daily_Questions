// Daily Problem 12th July

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted=arr.clone();
        Arrays.sort(sorted);
        int m=0;
        for(int i:sorted)
        {
            if (m==0 || sorted[m-1]!=i)
            {
                sorted[m++]=i;
            }
        }

        int[] unique = Arrays.copyOf(sorted, m);
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = Arrays.binarySearch(unique, arr[i]) + 1;
        }
        return arr;
    }
}