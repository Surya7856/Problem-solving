//https://leetcode.com/problems/longest-increasing-subsequence/?envType=daily-question&envId=2024-01-05
class Solution {
    int fun(int ind,int prev,int nums[],int n,int dp[][]){
        if(ind==n)
            return 0;
        if(dp[ind][prev+1]!=-1) return dp[ind][prev+1];
        int t=0;
        int nt=fun(ind+1,prev,nums,n,dp);
        if(prev==-1||nums[ind]>nums[prev]){
            t=1+fun(ind+1,ind,nums,n,dp);
        }
        return dp[ind][prev+1]=Math.max(t,nt);
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n+1][n+1];
        /* for(int i=0;i<n;i++)
            for(int j=0;j<=n;j++)
                dp[i][j]=-1;
        return fun(0,-1,nums,n,dp); */
        for(int i=n-1;i>=0;i--){
            for(int j=i-1;j>=-1;j--){
                int l=dp[i+1][j+1];
                if(j==-1||nums[i]>nums[j]){
                    l=Math.max(l,1+dp[i+1][i+1]);
                }
                dp[i][j+1]=l;
            }
        }
        return dp[0][0];
    }
}
