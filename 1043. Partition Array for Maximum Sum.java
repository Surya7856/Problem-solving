class Solution {
  //Tabulation
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int dp[]=new int[n+1];
        for(int ind=n-1;ind>=0;ind--){
            int ans=-1;
            int large=-1;
            for(int i=ind;i<Math.min(ind+k,n);i++){
                large=Math.max(large,arr[i]);
                ans=Math.max(ans,large*(i-ind+1)+dp[i+1]);
            }
            dp[ind]=ans;
        }
        return dp[0];
    }
}
// Memoziazation
    /*int fun(int ind,int arr[],int n,int k,int dp[]){
        if(ind==n)
            return 0;
        if(dp[ind]!=-1) return dp[ind];
        int sum=-1;
        int ans=-1;
        int large=-1;
        for(int i=ind;i<Math.min(ind+k,n);i++){
            large=Math.max(large,arr[i]);
            sum=large*(i-ind+1)+fun(i+1,arr,n,k,dp);
            ans=Math.max(ans,sum);
        }
        return dp[ind]=ans;
    }*/
//Inside the function
// for(int i=0;i<arr.length;i++)
        //     dp[i]=-1;
        // return fun(0,arr,arr.length,k,dp);
