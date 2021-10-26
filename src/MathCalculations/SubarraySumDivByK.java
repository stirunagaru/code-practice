package MathCalculations;

public class SubarraySumDivByK {
	public int subarraysDivByK(int[] nums, int k) {
        if(nums==null || nums.length==0) return 0;
        // int[] counts = new int[k];
        // int sum = 0;
        // for(int x: nums) {
        //     sum += (x%k + k)%k; // making -ve to +ve
        //     counts[sum % k]++;
        // }
        // int result = counts[0];
        // for(int c : counts) {
        //     result += (c*(c-1))/2;
        // }
        int result=0;
        int remSum=0;
        int[] map = new int[k];
        map[0]= 1;           //Freq of 0 as remainder is 1
        for(int x: nums) {
            remSum = (remSum + x) % k;
            if(remSum < 0)
                remSum += k;
            result+=map[remSum];
            map[remSum]++;
        }
        return result;
    }
}
