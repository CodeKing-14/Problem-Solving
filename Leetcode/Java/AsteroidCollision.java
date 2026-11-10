/*
Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [3,5,-6,2,-1,4]​​​​​​​
Output: [-6,2,4]
*/

import java.util.Stack;
import java.util.Arrays;

public class AsteroidCollision {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.asteroidCollision(new int[] { 8, -8 })));
    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int x : asteroids) {

            while (!st.isEmpty() && x < 0 && st.peek() > 0) {

                if (st.peek() < -x) {
                    st.pop();
                } else if (st.peek() == -x) {
                    st.pop();
                    x = 0;
                    break;
                } else {
                    x = 0;
                    break;
                }
            }

            if (x != 0) {
                st.push(x);
            }
        }

        int[] arr = new int[st.size()];

        for (int i = 0; i < st.size(); i++) {
            arr[i] = st.get(i);
        }

        return arr;
    }
}
