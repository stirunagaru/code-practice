package Sorting;

public class QuickSort {

	public static void main(String[] args) {
		int arr[] = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        
        System.out.println("Unsorted array");
        printArray(arr);
        
        QuickSort ob = new QuickSort();
        ob.quickSort(arr, 0, n-1);
  
        System.out.println("sorted array");
        printArray(arr);
	}
	
	static void printArray(int arr[])
	    {
	        int n = arr.length;
	        for (int i=0; i<n; ++i)
	            System.out.print(arr[i]+" ");
	        System.out.println();
	    }
	
	
	public void quickSort(int[] a, int low, int high) {
		int part = partition(a, low, high);
		if(low < part) {
			quickSort(a, low, part);
		}
		
		if(high> (part+1)) {
			quickSort(a, part+1, high);
		}
	}
	
	public int partition(int[] a, int l, int h) {
		int pt = a[h];
		System.out.println("PT:"+ pt);
		while(l<=h) {
			while(a[l] < pt) {l++;}
			while(a[h] > pt) {h--;}
			if(l<=h) {
				int temp = a[h];
				a[h]= a[l];
				a[l] = temp;
				l++;
				h--;
			}
		}
		return h;		
	}

}
