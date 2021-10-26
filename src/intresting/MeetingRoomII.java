package intresting;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class MeetingRoomII {
	 public int minMeetingRooms(int[][] intervals) {
         // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) return 0;
        
        
        // sorting intervals
//         Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        
//         //min heap
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>(intervals.length);
        
//         minHeap.add(intervals[0][1]); //end time of first meeting
        
//         for(int i = 1; i < intervals.length; i++) {
//             if(intervals[i][0] >= minHeap.peek()) 
//                 minHeap.poll();
//             minHeap.add(intervals[i][1]);
            
//         }
//         return minHeap.size();
        
           
        
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
         for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
         }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int endP = 0;
        int rooms = 0;
        
        for(int startP = 0; startP < starts.length; startP++)
            if(starts[startP] < ends[endP]) 
                rooms++;
            else 
                endP++;
        return rooms;
    
	 
//        Map<Integer, Integer> map = new TreeMap<>();
//        for (int[] itl : intervals) {
//            map.put(itl[0], map.getOrDefault(itl[0], 0) + 1);
//            map.put(itl[1], map.getOrDefault(itl[1], 0) - 1);
//        }
//        int room = 0, k = 0; 
//        for (int v : map.values()) 
//            k = Math.max(k, room += v); 
//        
//        return k;
	 }
}
