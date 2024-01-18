class Solution {
    //Memoization
    /* int fun(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n<0){
            return 0;
        }
        if(dp[n]!=-1)
            return dp[n];
        return dp[n]=fun(n-1,dp)+fun(n-2,dp);
    } */
    public int climbStairs(int n) {
        int prev1=0;
        int prev2=1;
        int count=0;
        for(int i=1;i<=n;i++){
            count=prev1+prev2;
            prev1=prev2;
            prev2=count;
        }
        return prev2;
    }
}
