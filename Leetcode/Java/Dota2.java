/*
Example 1:

Input: senate = "RD"
Output: "Radiant"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And in round 2, the first senator can just announce the victory since he is the only guy in the senate who can vote.
Example 2:

Input: senate = "RDD"
Output: "Dire"
Explanation: 
The first senator comes from Radiant and he can just ban the next senator's right in round 1. 
And the second senator can't exercise any rights anymore since his right has been banned. 
And the third senator comes from Dire and he can ban the first senator's right in round 1. 
And in round 2, the third senator can just announce the victory since he is the only guy in the senate who can vote.
*/



class Dota2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.predictPartyVictory("RDD"));
    }
}

class Solution {
    public String predictPartyVictory(String s) {
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        int d = 0;
        int r = 0;
        int dcount = 0;
        int rcount = 0;
        while (i < n) {
            if (s.charAt(i) == 'D') {
                dcount++;
                if (r > 0) {
                    r--;
                } else {
                    sb.append('D');
                    d++;
                }
            } else {
                rcount++;
                if (d > 0) {
                    d--;
                } else {
                    sb.append('R');
                    r++;
                }
            }
            i++;
            if (i == n) {
                s = sb.toString();
                n = sb.length();
                i = 0;

                if (dcount == 0) {
                    return "Radiant";
                } else if (rcount == 0) {
                    return "Dire";
                }

                sb = new StringBuilder();
                dcount = 0;
                rcount = 0;
            }

        }
        return "";
    }
}

