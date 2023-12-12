//Gold mine problem gfg
class Solution{
    //recursive approach by memoziation
    static int f(int i,int j,int n,int m,int M[][],int [][]dp){
        if(i<0||i>n){
            return 0;
        }
        if(j==m){
            return M[i][j];
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int rp=M[i][j]+f(i-1,j+1,n,m,M,dp);
        int rr=M[i][j]+f(i,j+1,n,m,M,dp);
        int rd=M[i][j]+f(i+1,j+1,n,m,M,dp);
        return dp[i][j]=Math.max(rp,Math.max(rr,rd));
    }
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                dp[i][j]=-1;
        }
        int max=0;
        
        
        //tabulation format
        
        
        for(int i=0;i<n;i++)
            dp[i][m-1]=M[i][m-1];
        
        for(int j=m-2;j>=0;j--){
            for(int i=0;i<n;i++){
                int rp=0,rr=0,rd=0;
                if(i>0)
                    rp=M[i][j]+dp[i-1][j+1];
                rr=M[i][j]+dp[i][j+1];
                if(i+1<n)
                    rd=M[i][j]+dp[i+1][j+1];
                dp[i][j]=Math.max(rp,Math.max(rr,rd));
            }
        }
        for(int i=0;i<n;i++){
            max=Math.max(max,dp[i][0]);
        }
        return max;
    }
}
