import java.util.* ;
import java.io.*; 
public class Solution
{
	static HashMap<String, Integer> memo = new HashMap<>();
	static int fun(int i,int j,int m,int n, ArrayList<ArrayList<Integer>> mat){
		if(i>m||j>n)
			return 0;
		String key = i + "," + j;
		if (memo.containsKey(key)) {
            return memo.get(key);
        }
		int r=0,d=0;
		if(i+1<=m && mat.get(i+1).get(j)>mat.get(i).get(j)){
			r=1+fun(i+1,j,m,n,mat);
		}
		if(j+1<=n&& mat.get(i).get(j+1)>mat.get(i).get(j)){
			d=1+fun(i,j+1,m,n,mat);
		}
		int ans=Math.max(1,Math.max(r,d));
		memo.put(key,ans);
		return ans;
	}
	public static int longestIncreasingPath(ArrayList<ArrayList<Integer>> mat, int n, int m)
	{
		// Write Your Code Here.
		memo.clear();
		return fun(0,0,n-1,m-1,mat);

	}
}
