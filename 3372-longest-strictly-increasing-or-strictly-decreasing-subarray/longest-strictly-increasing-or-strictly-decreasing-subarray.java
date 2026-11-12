class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incr=1;
        int max1=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                incr++;
            }else{
                incr=1;
            }
            max1=Math.max(max1,incr);
            System.out.println(max1+" "+incr);
        }
        int decr=1;
        int max2=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]){
                decr++;
            }else{
                decr=1;
            }
            max2=Math.max(max2,decr);
        }
        return Math.max(max1,max2);
    }
}