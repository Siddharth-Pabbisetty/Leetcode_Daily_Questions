// Daily Problem 3rd April

class Solution {

    public int maxWalls(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;
        int[] l=new int[n];
        int[] r=new int[n];
        int[] arr=new int[n];
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            mp.put(robots[i], distance[i]);
        }
        Arrays.sort(robots);
        Arrays.sort(walls);
        for(int i=0;i<n;i++)
        {
            int pos1=upperBound(walls,robots[i]);
            int leftPos=0;
            if(i>=1)
            {
                int leftBound=Math.max(robots[i]-mp.get(robots[i]),robots[i-1]+1);
                leftPos=lowerBound(walls, leftBound);
            }
            else
            {
                leftPos=lowerBound(walls,robots[i]-mp.get(robots[i]));
            }
            l[i]=pos1-leftPos;
            int rightPos=0;
            if(i<n-1)
            {
                int rightBound=Math.min(robots[i]+mp.get(robots[i]),robots[i+1]-1);
                rightPos=upperBound(walls,rightBound);
            }
            else
            {
                rightPos=upperBound(walls,robots[i]+mp.get(robots[i]));
            }
            int pos2=lowerBound(walls,robots[i]);
            r[i]=rightPos-pos2;
            if(i==0)
            {
                continue;
            }
            int pos3=lowerBound(walls,robots[i-1]);
            arr[i]=pos1-pos3;
        }
        int subLeft=l[0];
        int subRight=r[0];
        for(int i=1;i<n;i++)
        {
            int currentLeft=Math.max(subLeft+l[i],subRight-r[i-1] +Math.min(l[i]+r[i-1],arr[i]));
            int currentRight=Math.max(subLeft+r[i],subRight+r[i]);
            subLeft=currentLeft;
            subRight=currentRight;
        }
        return Math.max(subLeft,subRight);
    }

    private int lowerBound(int[] arr, int target)
    {
        int left=0;
        int right=arr.length;
        while(left < right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]<target)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return left;
    }

    private int upperBound(int[] arr, int target)
    {
        int left=0;
        int right=arr.length;
        while(left<right)
        {
            int mid=left+(right-left)/2;
            if(arr[mid]<=target)
            {
                left=mid+1;
            }
            else
            {
                right=mid;
            }
        }
        return left;
    }
}