/*
Example 1:

Input: s = "3[a]2[bc]"
Output: "aaabcbc"
Example 2:

Input: s = "3[a2[c]]"
Output: "accaccacc"
Example 3:

Input: s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
*/



class DecodeString {
    
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[bc]"));
    }
}

class Solution {
    int i = 0;

    public String decodeString(String s) {
        i = 0;
        return decode(s);
    }

    private String decode(String s) {
        StringBuilder res = new StringBuilder();
        int num = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
                i++;
            } else if (c == '[') {
                i++;
                String inner = decode(s);
                for (int k = 0; k < num; k++)
                    res.append(inner);
                num = 0;
            } else if (c == ']') {
                i++;
                return res.toString();
            } else {
                res.append(c);
                i++;
            }
        }
        return res.toString();
    }
}