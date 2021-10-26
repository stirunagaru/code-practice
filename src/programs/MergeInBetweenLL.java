package programs;

public class MergeInBetweenLL {
	 public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

//       ListNode aPrev = list1;
//       for(int i = 0; i < a-1 ; i++)
//           aPrev = aPrev.next;
      
//       ListNode bNext = aPrev;
//       for(int i = a-1; i < b+1 ; i++)
//           bNext = bNext.next;
      
      ListNode aPrev = null;
      ListNode bNext = list1;
      
      for(int i = 0; i <= b; i++) {
          if(i == a-1) 
              aPrev = bNext;
           bNext = bNext.next;
      }
      
      aPrev.next = list2;

      while(list2.next != null) {
          list2 = list2.next;
      }
      list2.next = bNext;
      return list1;
  }
}
