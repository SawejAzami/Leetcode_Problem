
class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1_000_000_007;

        long evenCount = 1; // Empty prefix sum = 0 (even)
        long oddCount = 0;

        long sum = 0;
        long ans = 0;

        for (int num : arr) {
            sum += num;

            if (sum % 2 == 0) {
                ans += oddCount;
                evenCount++;
            } else {
                ans += evenCount;
                oddCount++;
            }

            ans %= mod;
        }

        return (int) ans;
    }
}
