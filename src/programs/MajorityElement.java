package programs;

public class MajorityElement {
	 public int majorityElement(int[] nums) {
//       if(nums.length == 1) return nums[0];
//       Map<Integer, Integer> m = new HashMap<>();
//       int freq = nums.length/2;
//       for(int num : nums) {
//           if(m.containsKey(num)) {
//               int k = m.get(num);
//               if(++k > freq) 
//                   return num;
//               m.put(num, k);
//           } else {
//               m.put(num, 1);
//           }
//       }
//       return -1;
      int M = nums.length/2;
      int majority = nums[0];
      int count= 1;
      for(int i =1; i< nums.length;i++) {
          if(count == 0) {
              majority = nums[i];
              count =1;
          } else {
              if(majority == nums[i]) {
                  count++;
                  if(count > M) return majority;
              }
              else 
                  count--;
          }
      }
      return majority;
  }
  // count of initial number is 1
  // if the candidate is same as current, increment count 
  // if a number is repeated more times then the previous, then the count becomes = 0 
  // and hence the number will be assigned as candidate.

}
