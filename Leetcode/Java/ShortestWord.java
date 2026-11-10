// Given a string licensePlate and an array of strings words, find the shortest completing word in words.

// A completing word is a word that contains all the letters in licensePlate. Ignore numbers and spaces in licensePlate, and treat letters as case insensitive. If a letter appears more than once in licensePlate, then it must appear in the word the same number of times or more.

// For example, if licensePlate = "aBc 12c", then it contains letters 'a', 'b' (ignoring case), and 'c' twice. Possible completing words are "abccdef", "caaacab", and "cbca".

// Return the shortest completing word in words. It is guaranteed an answer exists. If there are multiple shortest completing words, return the first one that occurs in words.

 

// Example 1:

// Input: licensePlate = "1s3 PSt", words = ["step","steps","stripe","stepple"]
// Output: "steps"
// Explanation: licensePlate contains letters 's', 'p', 's' (ignoring case), and 't'.
// "step" contains 't' and 'p', but only contains 1 's'.
// "steps" contains 't', 'p', and both 's' characters.
// "stripe" is missing an 's'.
// "stepple" is missing an 's'.
// Since "steps" is the only word containing all the letters, that is the answer.
// Example 2:

// Input: licensePlate = "1s3 456", words = ["looks","pest","stew","show"]
// Output: "pest"
// Explanation: licensePlate only contains the letter 's'. All the words contain 's', but among these "pest", "stew", and "show" are shortest. The answer is "pest" because it is the word that appears earliest of the 3.

import java.util.ArrayList;
import java.util.List;

public class ShortestWord {
    public static void main(String[] args) {
        Solution obj = new Solution();
        String[] words = {"step","steps","stripe","stepple"};
        String licensePlate = "1s3 PSt";
        System.out.println(obj.shortestCompletingWord(licensePlate, words));
    }
}



class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        String lowerPlate = licensePlate.toLowerCase();
        List<String> result = new ArrayList<>();
        String resultWord = "";

        for (String word : words) {
            boolean valid = true;
            String lowerWord = word.toLowerCase();

            for (int i = 0; i < lowerPlate.length(); i++) {
                char ch = lowerPlate.charAt(i);

                if (ch >= 'a' && ch <= 'z') {
                    int plateCount = 0;
                    int wordCount = 0;

                    for (int j = 0; j < lowerPlate.length(); j++) {
                        if (lowerPlate.charAt(j) == ch) {
                            plateCount++;
                        }
                    }

                    for (int j = 0; j < lowerWord.length(); j++) {
                        if (lowerWord.charAt(j) == ch) {
                            wordCount++;
                        }
                    }

                    if (wordCount < plateCount) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                result.add(word);
            }
        }

        for (String word : result) {
            if (resultWord.isEmpty() || word.length() < resultWord.length()) {
                resultWord = word;
            }
        }

        return resultWord;
    }
}