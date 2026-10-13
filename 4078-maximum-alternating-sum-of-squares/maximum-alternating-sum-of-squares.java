class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            maxHeap.add(Math.abs(nums[i]));
        }
        int k=0;
        if(n%2==0){
            k=n/2;
        }else{
            k=n/2+1;
        }
        int i=0;
        int m=k;
        while(m>0){
            nums[i++]=maxHeap.poll();
            m--;
        }
        long  res=0;
        for(int j=0;j<k;j++){
            if(!maxHeap.isEmpty()){
                int b=nums[j];
                int a=maxHeap.poll();
                // System.out.println(a+" "+b);
                res+=(a+b)*(b-a);
            }else{
                res+=nums[j]*nums[j];
                // System.out.println(nums[j]);
            }
        }
        return res;
    }
}