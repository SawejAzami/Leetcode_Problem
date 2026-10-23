
class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(word);

            if (sb.toString().equals(s)) {
                return true;
            }

            // If the constructed string is longer than s,
            // it cannot become equal to s.
            if (sb.length() > s.length()) {
                return false;
            }
        }

        return false;
    }
}
