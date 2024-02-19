class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //Using BFS method
        int answer[]=new int[n];
        boolean visited[][]=new boolean[n][2];
        Queue<int[]> queue=new LinkedList<>();
        List<List<Integer>> adj[]=new ArrayList[n];
        //Making an adjacency list
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }
        for(int edge[]:redEdges){
            adj[edge[0]].add(Arrays.asList(edge[1],0));
        }
        for(int edge[]:blueEdges){
            adj[edge[0]].add(Arrays.asList(edge[1],1));
        }
        //Initilizing the base conditions
        Arrays.fill(answer,-1);
        answer[0]=0;
        visited[0][0]=visited[0][1]=true;
        queue.offer(new int[]{0,0,-1});
        while(!queue.isEmpty()){
            int[] element=queue.poll();
            int node=element[0],steps=element[1],prevColor=element[2];
            for(List<Integer> nei:adj[node]){
                int neighbor=nei.get(0);
                int color=nei.get(1);
                if(!visited[neighbor][color] && color!=prevColor){
                    if(answer[neighbor]==-1)
                        answer[neighbor]=steps+1;
                    visited[neighbor][color]=true;
                    queue.offer(new int[]{neighbor,steps+1,color});
                }
            }
        }
        return answer;
    }
}
