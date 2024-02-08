class Solution {
    public int numSquares(int n) {
        int sqr=(int)Math.sqrt(n);
        if(sqr*sqr==n)
            return 1;
        while(n%4==0)
            n/=4;
        if(n%8==7) return 4;
        for(int i=1;i*i<=n;i++){
            int sq=i*i;
            int base = (int) Math.sqrt(n - sq);
            if (base * base == n - sq) return 2;
        }
        return 3;
    }
}
//Tabulation
/*
public int numSquares(int n) {
        int dp[]=new int[n+1];
        for(int i=1;i<=n;i++){
            int min=n;
            for(int j=1;j*j<=i;j++){
                min=Math.min(min,1+dp[i-j*j]);
            }
            dp[i]=min;
        }
        return dp[n];
    }

*/
//Memoziazation
/*int fun(int num,int dp[]){
        if(num==0)
            return 0;
        if(dp[num]!=0) return dp[num];
        int min=num;
        for(int i=1;i*i<=num;i++){
            min=Math.min(min,1+fun(num-i*i,dp));
        }
        return dp[num]=min;
    }*/
