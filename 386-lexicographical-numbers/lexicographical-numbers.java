class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> li = new ArrayList<>();

        int curr = 1;

        for (int i = 0; i < n; i++) {
            li.add(curr);

            if (curr * 10 <= n) {
                // Go deeper
                curr *= 10;
            } else {
                // Go to next sibling / parent
                while (curr % 10 == 9 || curr + 1 > n) {
                    curr /= 10;
                }
                curr++;
            }
        }

        return li;
    }
}