package designquestions;

import java.util.*;

public class ZigZagIteratorUsing {
  Queue<Iterator> q = new LinkedList<>();
  public ZigZagIteratorUsing(List<Integer> v1, List<Integer> v2) {
    q = new LinkedList<>();
    if (!v1.isEmpty()) q.offer(v1.iterator());
    if (!v2.isEmpty()) q.offer(v2.iterator());
  }

  public int next() {
    Iterator cur = q.poll();
    int res =(int) cur.next();
    if(cur.hasNext()) q.offer(cur);
    return res;
}

  public boolean hasNext() {
    return q.peek() != null;
  }

  public static void main(String[] args) {
    List<Integer> v1 = new ArrayList<>();
    v1.addAll(Arrays.asList(1,2,3,4,5));
    List<Integer> v2 = new ArrayList<>();
    v2.addAll(Arrays.asList(6,7,8,9,10));
    ZigZagIteratorUsing z = new ZigZagIteratorUsing(v1, v2);
    for(int i = 0; i < v1.size() + v2.size(); i++)
      System.out.println(z.next());
    System.out.println(z.hasNext());
  }
}
