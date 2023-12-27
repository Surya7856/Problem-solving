//https://leetcode.com/problems/minimum-time-to-make-rope-colorful/?envType=daily-question&envId=2023-12-27
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n=neededTime.length;
        //last safe balloon index
        int lastballoon=0;
        int cost=0;
        for(int i=1;i<n;i++){
            //comparing previous balloon
            if(colors.charAt(i)!=colors.charAt(i-1))
                lastballoon=i;
            else{
                //if balloon are same comparing current balloon with last safe balloon
                if(neededTime[i]>neededTime[lastballoon]){
                    cost+=neededTime[lastballoon];
                    lastballoon=i;
                }
                //if cost of current balloon is less we add it to cost
                //and we remove that balloon
                else{
                    cost+=neededTime[i];
                }
            }
        }
        return cost;
    }
}
