package Graph;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] matrix = new int[n][n];
       
       for(int[] f : flights) { //matrix;
           matrix[f[0]][f[1]] = f[2];
       }
       
       
//        Map<Integer, List<int[]>> map = new HashMap<>();
       
//        for (int[] i: flights) {
//            if(!map.containsKey(i[0]))
//               map.put(i[0],new ArrayList<>());
//            map.get(i[0]).add(new int[]{i[1],i[2]});//key: source, values: list of des, cost
//        }
       
       
       int[] distances = new int[n];       //shortest distances array
       int[] currentStops = new int[n];    //  Shortest steps array

       Arrays.fill(distances, Integer.MAX_VALUE);
       Arrays.fill(currentStops, Integer.MAX_VALUE);
       distances[src] = 0;
       currentStops[src] = 0;
       
       Queue<int[]>  min = new PriorityQueue<>((a,b) -> a[1] - b[1]); //(node, cost, stops)
       
       min.offer(new int[]{src, 0, 0});

       while(!min.isEmpty()){
           int[] info = min.poll();
           int currNode = info[0], stops = info[2], currentCost = info[1];
       
           if(currNode == dst) return currentCost;
           if(stops == k+1) continue;
           
           for(int nei = 0; nei < n; nei++) {
               if(matrix[currNode][nei] > 0) {
                   int dV = currentCost + matrix[currNode][nei];
                   if(dV < distances[nei]) { //betterCost
                       min.offer(new int[]{nei, dV, stops+1});
                       distances[nei] = dV;
                   } else if(stops < currentStops[nei]) //better stops
                       min.offer(new int[]{nei, dV, stops + 1});
                   currentStops[nei] = stops;
               }
           }
           
           
           //  if(!map.containsKey(node))
           //     continue;
           //  for(int[] directions :  map.get(node)) { // all directions from that source;
           //      int dU = cost;
           //      int wUV = directions[1];
           //      if(dU +wUV < distances[directions[0]]) {
           //          min.offer(new int[]{directions[0], dU+wUV, stops+1});
           //      } else if(stops < currentStops[directions[0]]) {
           //          min.offer(new int[]{directions[0], dU+wUV, stops+1});
           //      }
           // }
       }     
       return distances[dst] == Integer.MAX_VALUE? -1 : distances[dst];       
   }
}
