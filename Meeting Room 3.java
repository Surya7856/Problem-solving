class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int roomcount[]=new int[n];
        long room_availabilityTime[]=new long[n];
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        for(int meeting[]:meetings){
            int start=meeting[0],end=meeting[1];
            boolean roomFound=false;
            long minRoomAvailableTime=Long.MAX_VALUE;
            int minAvailableRoom=0;
            for(int i=0;i<n;i++){
                if(room_availabilityTime[i]<=start){
                    roomFound=true;
                    roomcount[i]++;
                    room_availabilityTime[i]=end;
                    break;
                }
                if(minRoomAvailableTime>room_availabilityTime[i]){
                    minRoomAvailableTime=room_availabilityTime[i];
                    minAvailableRoom=i;
                }
            }
            if(!roomFound){
                room_availabilityTime[minAvailableRoom]+=end-start;
                roomcount[minAvailableRoom]++;
            }
        }
        int maxcount=0;int maxRoomIndex=0;
        for(int i=0;i<n;i++){
            if(roomcount[i]>maxcount){
                maxcount=roomcount[i];
                maxRoomIndex=i;
            }
        }
        return maxRoomIndex;
    }
}
