class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            } 
            else if (ch == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;
                high++;
            }

            // We have more ')' than possible '('
            if (high < 0) {
                return false;
            }

            // low cannot be negative
            if (low < 0) {
                low = 0;
            }
        }

        // If minimum possible unmatched '(' is 0,
        // the string can be valid.
        return low == 0;
    }
}