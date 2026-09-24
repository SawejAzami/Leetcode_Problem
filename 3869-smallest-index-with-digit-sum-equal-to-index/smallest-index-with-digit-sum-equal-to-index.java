class Solution {
    public static int sumOfDigit(int num){
        int sum=0;
        while(num>0){
            int rem=num%10;
            sum+=rem;
            num/=10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            int index=sumOfDigit(nums[i]);
            if(index==i)return i;
        }
        return -1;
    }
}