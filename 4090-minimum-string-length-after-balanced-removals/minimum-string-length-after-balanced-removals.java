class Solution {
    public int minLengthAfterRemovals(String s) {
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a') {
                count++;
            } else {
                count--;
            }
        }

        return Math.abs(count);
    }
}