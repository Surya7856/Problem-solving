//https://www.codingninjas.com/studio/problems/n-queens_759332?&interviewProblemRedirection=true
public class Solution {
    static void solve(int i,int n,ArrayList<ArrayList<Integer>> out,int[][] mat,int left[],int lowerdia[],int upperdia[]){
        if(i>=n){
            ArrayList<Integer> a=new ArrayList<>();
            for(int c=0;c<n;c++){
                for(int j=0;j<n;j++){
                    a.add(mat[c][j]);
                }
            }
            out.add(a);
        }
        for(int j=0;j<n;j++){
            if(left[j]==0 && lowerdia[i+j]==0 && upperdia[n-1-(i-j)]==0){
                mat[i][j]=1;
                left[j]=1;
                lowerdia[i+j]=1;
                upperdia[n-1-(i-j)]=1;
                solve(i+1,n,out,mat,left,lowerdia,upperdia);
                mat[i][j]=0;
                left[j]=0;
                lowerdia[i+j]=0;
                upperdia[n-1-(i-j)]=0;
            }
        }
    }
    public static ArrayList<ArrayList<Integer>> solveNQueens(int n) {
        // Write your code here.
        int[][] mat=new int[n][n];
        ArrayList<ArrayList<Integer>> out=new ArrayList<>();
        int left[]=new int[n];
        int lowerdia[]=new int[2*n-1];
        int upperdia[]=new int[2*n-1];
        solve(0,n,out,mat,left,lowerdia,upperdia);
        return out;

    }
}
