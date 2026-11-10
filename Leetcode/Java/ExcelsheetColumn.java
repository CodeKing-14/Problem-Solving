/*
Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnNumber = 1
Output: "A"
Example 2:

Input: columnNumber = 28
Output: "AB"
Example 3:

Input: columnNumber = 701
Output: "ZY"
 

Constraints:

1 <= columnNumber <= 231 - 1

*/


public class ExcelsheetColumn {
    public static void main(String... args) {
        Solution obj = new Solution();
        int columnNumber = 28;
        System.out.println(obj.convertToTitle(columnNumber));
    }
}


class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while(columnNumber > 0){
            columnNumber--;
            int curr = columnNumber%26;
            columnNumber/= 26;
            sb.append((char)(curr + 'A'));
        }

        return sb.reverse().toString();
    }
}
