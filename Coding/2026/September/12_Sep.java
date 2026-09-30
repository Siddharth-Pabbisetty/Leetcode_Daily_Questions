// Daily Problem 12th September

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n=intervals.size();
        int[][] arr=new int[n][4];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=intervals.get(i).get(0);
            arr[i][1]=intervals.get(i).get(1);
            arr[i][2]=intervals.get(i).get(2);
            arr[i][3]=i;
        }
        Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));
        long[][] dpWeight=new long[n+1][5];
        List<Integer>[][] dpList=new ArrayList[n+1][5];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=4;j++)
            {
                dpList[i][j]=new ArrayList<>();
            }
        }
        for(int i=1;i<=n;i++)
        {
            int len=arr[i-1][0];
            long w=arr[i-1][2];
            int id=arr[i-1][3];
            int l=1,h=i-1,prev=0;
            while(l<=h)
            {
                int mid=l+(h-l)/2;
                if(arr[mid-1][1]<len)
                {
                    prev=mid;
                    l=mid+1;
                }
                else
                {
                    h=mid-1;
                }
            }
            for(int j=1;j<=4;j++)
            {
                long skipW=dpWeight[i-1][j];
                List<Integer> skipList=dpList[i-1][j];
                long takeW=dpWeight[prev][j-1]+w;
                List<Integer> takeList = new ArrayList<>(dpList[prev][j-1]);
                takeList.add(id);
                Collections.sort(takeList);
                if (takeW > skipW)
                {
                    dpWeight[i][j]=takeW;
                    dpList[i][j]=takeList;
                }
                else if(takeW==skipW)
                {
                    if(isLexicographicallySmaller(takeList,skipList))
                    {
                        dpWeight[i][j]=takeW;
                        dpList[i][j]=takeList;
                    }
                    else
                    {
                        dpWeight[i][j]=skipW;
                        dpList[i][j]=skipList;
                    }
                }
                else
                {
                    dpWeight[i][j]=skipW;
                    dpList[i][j]=skipList;
                }
            }
        }
        List<Integer> resultList=dpList[n][4];
        int[] result=new int[resultList.size()];
        for(int i=0;i<resultList.size();i++)
        {
            result[i]=resultList.get(i);
        }
        return result;
    }

    private boolean isLexicographicallySmaller(List<Integer> a, List<Integer> b)
    {
        int size = Math.min(a.size(), b.size());
        for(int i=0;i<size;i++)
        {
            if(!a.get(i).equals(b.get(i)))
            {
                return a.get(i) < b.get(i);
            }
        }
        return a.size() < b.size();
    }
}