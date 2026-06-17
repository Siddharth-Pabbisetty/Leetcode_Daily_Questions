// Daily Problem 31st May

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long curr=mass;
        for(int i=0;i<asteroids.length;i++)
        {
            if(asteroids[i]>curr)
            {
                return false;
            }
            curr+=asteroids[i];
        }
        return true;
    }
}