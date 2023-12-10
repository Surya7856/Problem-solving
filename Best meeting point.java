ublic static int findBestMeetingPoint(ArrayList<ArrayList<Integer>> mat) {
  ///manhattan distance=|x2-x1|+|y2-y2|
  //Manhattan distance is shorest distance in vertical and horizontal manner
  //normal distance is shortest distance in diagonally way
		// Write your code here.
		ArrayList<Integer> x=new ArrayList<>();
		ArrayList<Integer> y=new ArrayList<>();
		int m=mat.size();
		int n=mat.get(0).size();
  //traversing along x to get x coordinates in sorted order
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(mat.get(i).get(j)==1){
					x.add(i);
				}
			}
		}
  //traversing along y to get y coordinates in sorted order
		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat.get(j).get(i)==1){
					y.add(i);
				}
			}
		}
  //finding medians of x and y respectively
		int xm=x.get(x.size()/2);
		int ym=y.get(y.size()/2);
  //calculating the manhattan distance
  //manhattan distance=|x2-x1|+|y2-y2|
		int sum=0;
		for(int i=0;i<x.size();i++){
			sum+=Math.abs(x.get(i)-xm);
			sum+=Math.abs(y.get(i)-ym);
		}
		return sum;
	}
