package intresting;

import java.util.PriorityQueue;

public class longestDiverseStringHAPPY {
	
    public String longestDiverseStringPQ(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[]{a, b, c};
        PriorityQueue<Character> pq = new PriorityQueue<>((x,y) -> freq[y-'a'] - freq[x-'a']);
        // PriorityQueue<Character> pq = new PriorityQueue<>((a1,b1)->{
        //     return f[b1 - 'a'] - f[a1 - 'a'];
        // });
        
        if(a > 0) pq.offer('a');
        if(b > 0) pq.offer('b');
        if(c > 0) pq.offer('c');
        
        while(!pq.isEmpty()) {
            int L = sb.length();
            char max = pq.poll();
            if(L < 2 || (sb.charAt(L-2) != max || sb.charAt(L-1) != max )) {
                sb.append(max);
                freq[max-'a']--;
            } else {
                if( pq.size() == 0) continue;
                char secondMx = pq.poll();
                sb.append(secondMx);
                freq[secondMx-'a']--;
                if(freq[secondMx-'a'] > 0) pq.offer(secondMx);
            }
            if(freq[max-'a'] > 0) pq.offer(max);
        }
        
        
        return sb.toString();
    }
	
	
	public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        int size = a + b + c;
        int A = 0, B = 0, C = 0;
        
        for(int i = 0; i < size; i++) {
            if((a>=b && a>=c && A != 2) || (B == 2 && a > 0) || (C==2 && a > 0)) {
                sb.append('a');
                a--; A++;
                B = 0; C = 0;
            } else if((b>=c && b>=a && B != 2) || (A == 2 && b > 0) || (C==2 && b > 0)) {
                sb.append('b');
                b--; B++;
                A = 0; C = 0;
            } else if((c>=a && c>=b && C != 2) || (B == 2 && c > 0) || (A==2 && c > 0)) {
                sb.append('c');
                c--; C++;
                B = 0; A = 0;
            }
        }
        
        
        return sb.toString();
        
    }
}
