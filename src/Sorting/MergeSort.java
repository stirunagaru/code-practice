package Sorting;

public class MergeSort {
    void merge(int arr[], int l, int m, int r)
    {
        int s1 = m-l+1;
        int s2 = r-m;
        int[] a = new int[s1];
        int[] b = new int[s2];
        for (int i = 0; i < s1; ++i)
            a[i] = arr[l + i];
        for (int j = 0; j < s2; ++j)
            b[j] = arr[m + 1 + j];
        
        int i=0;
        int j=0;
        int k=l;
        
        while(i < s1 && j < s2) {
        	if(a[i] <= b[j]) {
        		arr[k++] = a[i++];
        	} else {
        		arr[k++] = b[j++];
        	}
        }
        
        while(i < s1 ) arr[k++] = a[i++];
        while(j < s2 ) arr[k++] = b[j++];
        
    }
    
    private void mergeArray(int[] nums, int low, int middle, int high) {
        int lp = low;
        int rp = middle+1;
        
        int[] buff = new int[high - low + 1];
        int bp = 0;
        
        while(lp <= middle && rp <= high){
            if(nums[lp] <= nums[rp]) buff[bp++] = nums[lp++];
            else buff[bp++] = nums[rp++];
        }
        
        //remaing elements
        while(lp <= middle) buff[bp++] = nums[lp++];
        while(rp <= high) buff[bp++] = nums[rp++];
        
        
        for(int i = low; i <= high ; i++){
            nums[i] = buff[i-low];
        }
    } 
    void mergeSort(int arr[], int l, int r)
    {
        if(l<r) {
            int m = (l+r)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
//            merge(arr, l, m, r); // not optimized

            mergeArray(arr, l, m, r); 
        }
    }
    
	public static void main(String[] args) {
		int arr[] = {5,2,3,1};
        int n = arr.length;
        
        System.out.println("Unsorted array");
        printArray(arr);
        
        MergeSort ob = new MergeSort();
        ob.mergeSort(arr, 0, n-1);
  
        System.out.println("sorted array");
        printArray(arr);
	}
	
	static void printArray(int[] arr)
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
}
