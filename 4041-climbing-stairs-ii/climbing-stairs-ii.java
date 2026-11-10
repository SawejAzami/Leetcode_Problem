class Solution {
    public int findCost(int i,int n,int[] cost,int[] dp){
        if(i==n)return 0;
        if(dp[i]!=-1){
            return dp[i];
        }

        int step1=Integer.MAX_VALUE;
        int step2=Integer.MAX_VALUE;
        int step3=Integer.MAX_VALUE;
        if(i+1<=n){
            step1=cost[i]+1+findCost(i+1,n,cost,dp);
        }
        if(i+2<=n){
            step2=cost[i+1]+4+findCost(i+2,n,cost,dp);
        }
        if(i+3<=n){
            step3=cost[i+2]+9+findCost(i+3,n,cost,dp);
        }
        return dp[i]=Math.min(step1,Math.min(step2,step3));
    }
    public int climbStairs(int n, int[] costs) {
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return findCost(0,n,costs,dp);
    }
}