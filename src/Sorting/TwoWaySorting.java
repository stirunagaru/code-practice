package Sorting;

public class TwoWaySorting {
	    public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int[] temp = new int[m];
	        for(int k = 0; k < m; k++) {
	            temp[k] = nums1[k];
	        }
	        
	        int i = 0; int j=0; int k=0;
	        while(i < m && j < n) {
	            if(temp[i] < nums2[j]) {
	                nums1[k++] = temp[i++];
	            } else {
	                nums1[k++] = nums2[j++];
	            }
	        }
	        
	        while(i < m) nums1[k++] = temp[i++];
	        while(j < n) nums1[k++] = nums2[j++];        
	    }
	    
	    public void withoutExtraArray(int[] nums1,int m, int[] nums2, int n) {
	        int i = m-1;
	        int j = n-1;
	        int k = m+n -1;
	        while(i >= 0 && j >= 0){
	            if(nums1[i] <= nums2[j]) {
	                nums1[k--] = nums2[j--];
	            } else {
	                nums1[k--] = nums1[i--];
	            }
	        }
	        
	        while(j >= 0){
	            nums1[k--] = nums2[j--]; 
	        }
	    }
	    
	    public void oneLine(int[] nums1,int m, int[] nums2, int n) {
	        int i = m-1;
	        int j = n-1;
	        int k = m+n -1;
	        while(j >= 0) {
	        	nums1[k--] = (i>0 || nums2[j] > nums1[i]) ? nums2[j--] : nums1[i--];
	        }
	    }
}