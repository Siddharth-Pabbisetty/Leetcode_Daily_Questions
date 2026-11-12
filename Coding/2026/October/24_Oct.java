// Daily Problem 24th October

class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        return Math.max(0,Math.min(solve(leaveAlice),solve(leaveBob))-Math.max(solve(arriveAlice),solve(arriveBob))+1);
    }

    int solve(String str)
    {
        int alice=(str.charAt(0)-'0')*10+(str.charAt(1)-'0');
        int bob=(str.charAt(3)-'0')*10+(str.charAt(4)-'0');

        return (275*alice)/9-2*((alice+9)/12)+bob-30;
    }
}