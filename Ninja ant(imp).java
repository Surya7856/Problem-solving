public static ArrayList<Integer> ninjaAnt(int[][] mat, int sr, int sc, int moves) {		 
		// Write your code here.
		ArrayList<Integer> out=new ArrayList<>();
		int n=mat.length;
  //{North,East,South,West} respectvely
  //here 2D array is to move from one direction other direction 
  //right one is right side of following direction
  //left one is left side of following direction
		int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
  //Initialising current direction as East
		int curdir=1;
		for(int i=0;i<moves;i++){
      //if 1 moving right
			if(mat[sr][sc]==1){
				mat[sr][sc]=0;
				curdir=(curdir+1)%4;
			}
      //else moving left
			else{
				mat[sr][sc]=1;
				curdir=(curdir-1+4)%4;
			}
      //changing the direction
			sr+=dir[curdir][0];
			sc+=dir[curdir][1];
      //return if the index are invalid
			if(sr>=n||sc>=n||sc<0||sr<0){
				out.add(-1);
				out.add(-1);
				return out;
			}
		}
  //returning final position
		out.add(sr);
		out.add(sc);
		return out;
	}
