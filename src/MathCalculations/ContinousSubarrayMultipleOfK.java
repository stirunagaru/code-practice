package MathCalculations;

import java.util.HashMap;
import java.util.Map;

public class ContinousSubarrayMultipleOfK {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        int rem =0;
        m.put(0, -1);
        for(int i = 0; i< nums.length; i++) {
            rem += nums[i];
            if(k!=0) rem %= k;
            if(m.containsKey(rem) && i-m.get(rem) > 1) return true;
            m.putIfAbsent(rem, i);
        }
        return false;
    }
}
