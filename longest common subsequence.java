class Solution {
    //memoziation
    /*int fun(int i,int j,String text1,String text2,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j))
            return dp[i][j]=1+fun(i-1,j-1,text1,text2,dp);
        else{
            return dp[i][j]=Math.max(fun(i-1,j,text1,text2,dp),fun(i,j-1,text1,text2,dp));
        }
    }*/
    public int longestCommonSubsequence(String text1, String text2) {
        int l1=text1.length();
        int l2=text2.length();
        int dp[][]=new int[l1+1][l2+1];
        // memoziation
        // for(int i=0;i<l1;i++)
        //     for(int j=0;j<l2;j++)
        //         dp[i][j]=-1;
        // tabulation without space optimization
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[l1][l2];
        // return fun(l1-1,l2-1,text1,text2,dp);

        // tabulation with space optimization
        /*int prev[]=new int[l2+1];
        int cur[]=new int[l2+1];
        for(int i=1;i<=l1;i++){
            for(int j=1;j<=l2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    cur[j]=1+prev[j-1];
                else
                    cur[j]=Math.max(prev[j],cur[j-1]);
            }
            prev=cur;
        }
        return prev[l2];*/
    }
}
